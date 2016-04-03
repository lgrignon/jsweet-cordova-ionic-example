package org.jsweet.ionicexercise.client;

import static def.jquery.Globals.$;
import static def.underscore.Globals._;
import static jsweet.dom.Globals.console;
import static jsweet.dom.Globals.setInterval;
import static jsweet.dom.Globals.window;
import static jsweet.lang.Globals.parseInt;
import static jsweet.util.Globals.$get;
import static jsweet.util.Globals.array;
import static jsweet.util.Globals.function;
import static jsweet.util.Globals.object;
import static jsweet.util.Globals.string;
import static jsweet.util.Globals.union;

import java.util.function.Consumer;

import def.es6_promise.Promise;
import def.es6_promise.Promise.CallbackBiConsumer;
import def.underscore._.Dictionary;
import jsweet.dom.Blob;
import jsweet.dom.Event;
import jsweet.dom.FormData;
import jsweet.dom.ProgressEvent;
import jsweet.dom.XMLHttpRequest;
import jsweet.lang.Array;
import jsweet.lang.Error;
import jsweet.lang.Interface;
import jsweet.lang.JSON;
import jsweet.lang.Optional;
import jsweet.lang.RegExp;
import jsweet.util.union.Union;
import jsweet.util.union.Union3;

@Interface
abstract class AjaxResponse<T> {
	Integer statusCode;

	String contentType;

	@Optional
	Integer contentLength;

	Union3<Object, String, T> response;

	@Optional
	Consumer<T> onSuccess;

	@Optional
	Consumer<Object> onError;

	@Optional
	Runnable onComplete;

	// @Optional
	// onUnauthorized?: (path: string) => void;
}

public class Server {

	private boolean online;

	private String webRoot = "";
	private String pingPath = null;

	private Array<Consumer<Boolean>> connectivityListeners = new Array<>();
	private jsweet.lang.Object persistentHeaders = new jsweet.lang.Object();
	private Array<Consumer<Object>> requestParametersInterceptor = new Array<>();

	private boolean requestedWithHeaderDisabled;

	Server() {
		this.online = false;

		this.checkServer();
		setInterval(function(() -> {
			this.checkServer();
		}), 5000);
	}

	@SuppressWarnings("unchecked")
	private Server addRequestParametersInterceptor(Consumer<Object> interceptor) {
		this.requestParametersInterceptor.push(interceptor);
		return this;
	}

	public Server addPersistentHeader(String name, String value) {
		this.persistentHeaders.$set(name, value);
		return this;
	}

	private Server removePersistentHeader(String name) {
		this.persistentHeaders.$delete(name);
		return this;
	}

	private String setQueryStringParam(String url, String param, Object value) {
		if ($.isArray(value)) {
			Object[] values = (Object[]) value;
			for (int i = 0; i < values.length; i++) {
				url = setQueryStringParam(url, param, values[i]);
			}
			return url;
		}

		url = string(url).replace(new RegExp(param + "=[^&]*[&]?"), "");
		url = string(url).replace("#", "");
		return url + (url.indexOf("?") != -1 ? "&" : "?") + param + "=" + value;
	}

	private String getUrl(String path, jsweet.lang.Object params) {
		String url = this.webRoot + path;

		if (params != null) {
			String[] keys = jsweet.lang.Object.keys(params);
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				url = setQueryStringParam(url, key, object(params.$get(key)));
			}
		}
		return url;
	}

	public boolean isOnline() {

		return this.online;
	}

	public <T> void get(String path, jsweet.lang.Object parameters, Consumer<T> onSuccess) {

		String url = this.getUrl(path, null);
		Object data = parameters == null ? new jsweet.lang.Object() : parameters;

		this.invokeRequestParametersInterceptors(data);

		String[] dataKeys = jsweet.lang.Object.keys(data);
		for (String key : dataKeys) {
			url = setQueryStringParam(url, key, object(data).$get(key));
		}

		this.doRequest("GET", url,  null, onSuccess);
	}

	public <T> void post(String path, Object parameter, Consumer<T> onSuccess) {

		Object data = parameter;
		if (data == null) {
			data = new jsweet.lang.Object();
		}

		this.invokeRequestParametersInterceptors(data);

		jsweet.lang.Object headers = this.getAllHeaders();

		Union<String, FormData> formData = null;
		if (!_.isEmpty(data)) {

			if (headers.$get("Content-Type") == "application/json") {
				// if json request content type forced, lets encode parameters
				// properly
				formData = union(JSON.stringify(data));
			} else {
				FormData formDataObject = new FormData();

				_.each((Dictionary<?>) data, (value, name, __) -> {
					formDataObject.append(name, value);

					return null;
				});

				formData = union(formDataObject);
			}
		}

		this.doRequest("POST", this.getUrl(path, null), formData, onSuccess);
	}

	private <T> void doRequest( //
			String method, //
			String url, //
			Union<String, FormData> formData, Consumer<T> onSuccess) {

		XMLHttpRequest xhr = new XMLHttpRequest();

		this.<T> installXMLHttpRequestListeners(xhr, onSuccess, (error) -> {

			console.error("failed to request " + url, error);

		});

		xhr.open(method, url, true);

		@SuppressWarnings("unchecked")
		Dictionary<String> headers = (Dictionary<String>) this.getAllHeaders();
		_.each(headers, (value, key, __) -> {
			xhr.setRequestHeader(key, value);

			return null;
		});
		xhr.send(formData);
	}

	private jsweet.lang.Object getAllHeaders() {
		Object requestHeaders = null;

		jsweet.lang.Object headers = object($.extend(new jsweet.lang.Object(), this.persistentHeaders, requestHeaders));

		if (!requestedWithHeaderDisabled) {
			headers.$set("X-Requested-With", "XMLHttpRequest");
		}

		return headers;
	}

	private <T> void installXMLHttpRequestListeners(XMLHttpRequest xhr, Consumer<T> resolve, Consumer<Object> reject) {
		xhr.onload = (Event ev) -> {
			// TODO bug
			// onXMLHttpRequestComplete(xhr, resolve, reject); bug
			this.<T> onXMLHttpRequestComplete(xhr, resolve, reject);

			return null;
		};
		xhr.onerror = e -> {
			reject.accept(e);
			return null;
		};
	}

	@SuppressWarnings("unchecked")
	public Server addConnectivityListener(Consumer<Boolean> listener) {
		this.connectivityListeners.push(listener);
		return this;
	}

	private void invokeRequestParametersInterceptors(Object data) {
		_.each(array(this.requestParametersInterceptor), (interceptor, idx, __) -> {
			interceptor.accept(data);

			return null;
		});
	}

	public Server setPingPath(String path) {
		this.pingPath = path;
		this.checkServer();
		return this;
	}

	public boolean isPingEnabled() {
		return this.pingPath != null;
	}

	private void checkServer() {
		if (!this.isPingEnabled()) {
			return;
		}

		XMLHttpRequest req = new XMLHttpRequest();
		req.open("GET", this.webRoot + this.pingPath, true);
		req.onload = (event) -> {
			if (req.status == 200) {
				this.setConnectivity(true);
			} else {
				this.setConnectivity(false);
			}

			return null;
		};
		req.onerror = e -> {
			console.error(e);
			this.setConnectivity(false);

			return null;
		};

		try {
			req.send();
		} catch (Error e) {
			if (e.name == "NetworkError") {
				this.setConnectivity(false);
			} else {
				throw e;
			}
		}
	}

	private void setConnectivity(boolean online) {
		if (online != this.online) {
			console.info("online state changed: " + this.online + " => " + online);
			this.online = online;
			this.connectivityListeners.forEach((listener) -> {
				listener.accept(online);
			});
		}
	}

	private static Server theInstance = new Server();

	public static Server instance() {
		return theInstance;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

	private <T> void handleTextResponse(AjaxResponse<T> options) {
		if (options.statusCode != 200) {
			console.warn("ajax request error (text response): " + options.response);
			options.onError.accept(union(options.response));
			// TODO
			// Notifications.error(label('label.serverError'));
		} else {
			options.onSuccess.accept(union(options.response));
		}
	}

	@SuppressWarnings("unchecked")
	private <T> void handleJsonResponse(AjaxResponse<T> options) {
		jsweet.lang.Object data = null;
		if (union(options.response) != "") {
			data = object(JSON.parse(union(options.response), (key, value) -> {
				return value;
			}));
		}
		if (data == null) {
			data = new jsweet.lang.Object();
		}

		if (data.hasOwnProperty("error") && data.$get("error") != null || options.statusCode != 200) {
			console.warn("ajax request error: ");

			Object error = object(data.$get("error"));
			console.warn(error);

			options.onError.accept(error);
		} else {
			options.onSuccess.accept((T) data);
		}
	}

	private <T> void onAjaxRequestComplete(AjaxResponse<T> options) {

		if (options.onComplete == null) {
			options.onComplete = $::noop;
		}

		if (options.onSuccess == null) {
			options.onSuccess = r -> {
			};
		}

		if (options.onError == null) {
			options.onError = e -> {
			};
		}

		options.onComplete.run();

		if (options.statusCode == null) {
			options.statusCode = 200;
		}

		// Invalid access
		if (options.statusCode == 401) {
			// if ($.isFunction(settings.onUnauthorized)) {
			// settings.onUnauthorized(document.location.pathname +
			// document.location.search);
			// return;
			// }
			// document.location.href = url("rui", "login")
			// + "?requestedUrl="
			// + encodeURIComponent(document.location.pathname
			// + document.location.search) + "&__notification="
			// + label("msg.disconnectedPleaseLogIn");
			options.onError.accept(string("unauthorized"));
			return;
		}

		try {
			if (options.contentType != null && options.contentType != "application/json"
					&& options.contentType != "text/x-json") {
				// TODO: fix bug to remove this
				this.handleTextResponse(options);
			} else {
				// TODO: fix bug to remove this
				this.handleJsonResponse(options);
			}
		} catch (Error e) {
			console.error(object(e), "error in response handling" + options.response);
			options.onError.accept(object(e));
			throw e;
		}
	}

	private <T> void onXMLHttpRequestComplete(XMLHttpRequest request, Consumer<T> onSuccessCallback,
			Consumer<Object> onErrorCallback) {

		console.log("on load end ", request);

		// Gets content type (removes charset if any) & defaults to json
		String contentType = request.getResponseHeader("content-type");
		if (contentType == null) {
			contentType = "application/json";
		}

		if (contentType.indexOf(";") != -1) {
			contentType = contentType.substring(0, contentType.indexOf(";"));
		}

		Integer contentLength = null;
		if (request.getResponseHeader("content-length") != null) {
			contentLength = (int) parseInt(request.getResponseHeader("content-length"));
		}

		Object responseObject;
		if (request.responseType != null && (request.responseType == "blob" || request.responseType == "arraybuffer")
				&& request.response != null) {

			responseObject = object(request.response);
		} else {
			responseObject = object(request.responseText);
		}

		String responseContentType = contentType;
		Integer responseContentLength = contentLength;
		AjaxResponse<T> responseInfos = new AjaxResponse<T>() {
			{
				statusCode = (int) request.status;
				response = union(union(responseObject));
				contentType = responseContentType;
				contentLength = responseContentLength;
				onSuccess = onSuccessCallback;
				onError = onErrorCallback;
			}
		};

		this.onAjaxRequestComplete(responseInfos);
	}

	private void disableRequestedWithHeader() {
		requestedWithHeaderDisabled = true;
	}
}
