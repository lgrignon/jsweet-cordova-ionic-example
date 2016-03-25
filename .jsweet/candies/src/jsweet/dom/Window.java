package jsweet.dom;
/**  <p><span>The <code>window</code> object represents a window containing a DOM document; the <code>document</code> property points to the DOM document loaded in that window.</span> A window for a given document can be obtained using the <code>document.defaultView</code> property.</p> <p>This section provides a brief reference for all of the methods, properties, and events available through the DOM <code>window</code> object. The <code>window</code> object implements the <code>Window</code> interface, which in turn inherits from the <code>AbstractView</code> interface. Some additional global functions, namespaces, objects, interfaces, and constructors, not typically associated with the window, but available on it, are listed in the JavaScript Reference and DOM Reference.</p> <p>In a tabbed browser, such as Firefox, each tab contains its own <code>window</code> object (and if you're writing an extension, the browser window itself is a separate window too - see Working with windows in chrome code for more information). That is, the <code>window</code> object is not shared between tabs in the same window. Some methods, namely <code>window.resizeTo</code> and <code>window.resizeBy</code> apply to the whole window and not to the specific tab the <code>window</code> object belongs to. Generally, anything that can't reasonably pertain to a tab pertains to the window instead.</p>  */
@jsweet.lang.Extends({WindowTimers.class,WindowSessionStorage.class,WindowLocalStorage.class,WindowConsole.class,GlobalEventHandlers.class,IDBEnvironment.class,WindowBase64.class})
public class Window extends EventTarget implements Iterable<Window> {
    public double animationStartTime;
    /** 
 An <code>OfflineResourceList</code> object providing access to the offline resources for the window.  */
    public ApplicationCache applicationCache;
    public Navigator clientInformation;
    /** 
 This property indicates whether the current window is closed or not.  */
    public Boolean closed;
    /** 
 Returns the browser crypto object.  */
    public Crypto crypto;
    /** 
 Gets/sets the status bar text for the given window.  */
    public String defaultStatus;
    /** 
 Returns the ratio between physical pixels and device independent pixels in the current display.  */
    public double devicePixelRatio;
    public String doNotTrack;
    /** 
 Returns a reference to the document that the window contains.  */
    public Document document;
    public Event event;
    public External external;
    /** 
 Returns the element in which the window is embedded, or null if the window is not embedded.  */
    public Element frameElement;
    /** 
 Returns an array of the subframes in the current window.  */
    public Window frames;
    /** 
 Returns a reference to the history object.  */
    public History history;
    /** 
 Gets the height of the content area of the browser window including, if rendered, the horizontal scrollbar.  */
    public double innerHeight;
    /** 
 Gets the width of the content area of the browser window including, if rendered, the vertical scrollbar.  */
    public double innerWidth;
    /** 
 Returns the number of frames in the window. See also <code>window.frames</code>.  */
    public double length;
    /** 
 Gets/sets the location, or current URL, of the window object.  */
    public Location location;
    /** 
 Returns the locationbar object, whose visibility can be toggled in the window.  */
    public BarProp locationbar;
    /** 
 Returns the menubar object, whose visibility can be toggled in the window.  */
    public BarProp menubar;
    public double msAnimationStartTime;
    public MSTemplatePrinter msTemplatePrinter;
    /** 
 Gets/sets the name of the window.  */
    public String name;
    /** 
 Returns a reference to the navigator object.  */
    public Navigator navigator;
    public jsweet.util.union.Union<String,Boolean> offscreenBuffering;
    public java.util.function.Function<Event,Object> onabort;
    public java.util.function.Function<Event,Object> onafterprint;
    public java.util.function.Function<Event,Object> onbeforeprint;
    public java.util.function.Function<BeforeUnloadEvent,Object> onbeforeunload;
    public java.util.function.Function<FocusEvent,Object> onblur;
    public java.util.function.Function<Event,Object> oncanplay;
    public java.util.function.Function<Event,Object> oncanplaythrough;
    public java.util.function.Function<Event,Object> onchange;
    public java.util.function.Function<MouseEvent,Object> onclick;
    public java.util.function.Function<Event,Object> oncompassneedscalibration;
    public java.util.function.Function<PointerEvent,Object> oncontextmenu;
    public java.util.function.Function<MouseEvent,Object> ondblclick;
    /** <span><strong>FIXME:</strong> <em>NeedsContents</em></span>  */
    public java.util.function.Function<DeviceMotionEvent,Object> ondevicemotion;
    /** 
 An event handler property for any device orientation changes  */
    public java.util.function.Function<DeviceOrientationEvent,Object> ondeviceorientation;
    public java.util.function.Function<DragEvent,Object> ondrag;
    public java.util.function.Function<DragEvent,Object> ondragend;
    public java.util.function.Function<DragEvent,Object> ondragenter;
    public java.util.function.Function<DragEvent,Object> ondragleave;
    public java.util.function.Function<DragEvent,Object> ondragover;
    public java.util.function.Function<DragEvent,Object> ondragstart;
    public java.util.function.Function<DragEvent,Object> ondrop;
    public java.util.function.Function<Event,Object> ondurationchange;
    public java.util.function.Function<Event,Object> onemptied;
    public java.util.function.Function<Event,Object> onended;
    public ErrorEventHandler onerror;
    public java.util.function.Function<FocusEvent,Object> onfocus;
    public java.util.function.Function<HashChangeEvent,Object> onhashchange;
    public java.util.function.Function<Event,Object> oninput;
    public java.util.function.Function<KeyboardEvent,Object> onkeydown;
    public java.util.function.Function<KeyboardEvent,Object> onkeypress;
    public java.util.function.Function<KeyboardEvent,Object> onkeyup;
    public java.util.function.Function<Event,Object> onload;
    public java.util.function.Function<Event,Object> onloadeddata;
    public java.util.function.Function<Event,Object> onloadedmetadata;
    public java.util.function.Function<Event,Object> onloadstart;
    public java.util.function.Function<MessageEvent,Object> onmessage;
    public java.util.function.Function<MouseEvent,Object> onmousedown;
    public java.util.function.Function<MouseEvent,Object> onmouseenter;
    public java.util.function.Function<MouseEvent,Object> onmouseleave;
    public java.util.function.Function<MouseEvent,Object> onmousemove;
    public java.util.function.Function<MouseEvent,Object> onmouseout;
    public java.util.function.Function<MouseEvent,Object> onmouseover;
    public java.util.function.Function<MouseEvent,Object> onmouseup;
    public java.util.function.Function<MouseWheelEvent,Object> onmousewheel;
    public java.util.function.Function<MSGestureEvent,Object> onmsgesturechange;
    public java.util.function.Function<MSGestureEvent,Object> onmsgesturedoubletap;
    public java.util.function.Function<MSGestureEvent,Object> onmsgestureend;
    public java.util.function.Function<MSGestureEvent,Object> onmsgesturehold;
    public java.util.function.Function<MSGestureEvent,Object> onmsgesturestart;
    public java.util.function.Function<MSGestureEvent,Object> onmsgesturetap;
    public java.util.function.Function<MSGestureEvent,Object> onmsinertiastart;
    public java.util.function.Function<MSPointerEvent,Object> onmspointercancel;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerdown;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerenter;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerleave;
    public java.util.function.Function<MSPointerEvent,Object> onmspointermove;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerout;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerover;
    public java.util.function.Function<MSPointerEvent,Object> onmspointerup;
    public java.util.function.Function<Event,Object> onoffline;
    public java.util.function.Function<Event,Object> ononline;
    public java.util.function.Function<Event,Object> onorientationchange;
    public java.util.function.Function<PageTransitionEvent,Object> onpagehide;
    public java.util.function.Function<PageTransitionEvent,Object> onpageshow;
    public java.util.function.Function<Event,Object> onpause;
    public java.util.function.Function<Event,Object> onplay;
    public java.util.function.Function<Event,Object> onplaying;
    public java.util.function.Function<PopStateEvent,Object> onpopstate;
    public java.util.function.Function<ProgressEvent,Object> onprogress;
    public java.util.function.Function<Event,Object> onratechange;
    public java.util.function.Function<ProgressEvent,Object> onreadystatechange;
    public java.util.function.Function<Event,Object> onreset;
    public java.util.function.Function<UIEvent,Object> onresize;
    public java.util.function.Function<UIEvent,Object> onscroll;
    public java.util.function.Function<Event,Object> onseeked;
    public java.util.function.Function<Event,Object> onseeking;
    public java.util.function.Function<UIEvent,Object> onselect;
    public java.util.function.Function<Event,Object> onstalled;
    public java.util.function.Function<StorageEvent,Object> onstorage;
    public java.util.function.Function<Event,Object> onsubmit;
    public java.util.function.Function<Event,Object> onsuspend;
    public java.util.function.Function<Event,Object> ontimeupdate;
    public Object ontouchcancel;
    public Object ontouchend;
    public Object ontouchmove;
    public Object ontouchstart;
    /** 
 An event handler property for unload events on the window.  */
    public java.util.function.Function<Event,Object> onunload;
    public java.util.function.Function<Event,Object> onvolumechange;
    public java.util.function.Function<Event,Object> onwaiting;
    /** 
 Returns a reference to the window that opened this current window.  */
    public Window opener;
    public jsweet.util.union.Union<String,Double> orientation;
    /** 
 Gets the height of the outside of the browser window.  */
    public double outerHeight;
    /** 
 Gets the width of the outside of the browser window.  */
    public double outerWidth;
    /** 
 An alias for <code>window.scrollX</code>.  */
    public double pageXOffset;
    /** 
 An alias for <code>window.scrollY</code>  */
    public double pageYOffset;
    /** 
 Returns a reference to the parent of the current window or subframe.  */
    public Window parent;
    /** 
 Provides a hosting area for performance related attributes.  */
    public Performance performance;
    /** 
 Returns the personalbar object, whose visibility can be toggled in the window.  */
    public BarProp personalbar;
    /** 
 Returns a reference to the screen object associated with the window.  */
    public Screen screen;
    public double screenLeft;
    public double screenTop;
    /** 
 Returns the horizontal distance of the left border of the user's browser from the left side of the screen.  */
    public double screenX;
    /** 
 Returns the vertical distance of the top border of the user's browser from the top side of the screen.  */
    public double screenY;
    /** 
 Returns the number of pixels that the document has already been scrolled horizontally.  */
    public double scrollX;
    /** 
 Returns the number of pixels that the document has already been scrolled vertically.  */
    public double scrollY;
    /** 
 Returns the scrollbars object, whose visibility can be toggled in the window.  */
    public BarProp scrollbars;
    /** 
 Returns an object reference to the window object itself.  */
    public Window self;
    /** 
 Gets/sets the text in the statusbar at the bottom of the browser.  */
    public String status;
    /** 
 Returns the statusbar object, whose visibility can be toggled in the window.  */
    public BarProp statusbar;
    public StyleMedia styleMedia;
    /** 
 Returns the toolbar object, whose visibility can be toggled in the window.  */
    public BarProp toolbar;
    /** 
 Returns a reference to the topmost window in the window hierarchy. This property is read only.  */
    public Window top;
    /** 
 Returns a reference to the current window.  */
    public Window window;
    public URL URL;
    /** 
 Displays an alert dialog.  */
    native public void alert(Object message);
    /** 
 Sets focus away from the window.  */
    native public void blur();
    native public void cancelAnimationFrame(double handle);
    /** 
 Registers the window to capture all events of the specified type.  */
    native public void captureEvents();
    /** 
 Closes the current window.  */
    native public void close();
    /** 
 Displays a dialog with a message that the user needs to respond to.  */
    native public Boolean confirm(String message);
    /** 
 Sets focus on the current window.  */
    native public void focus();
    /** 
 Gets computed style for the specified element. Computed style indicates the computed values of all CSS properties of the element.  */
    native public CSSStyleDeclaration getComputedStyle(Element elt, String pseudoElt);
    native public CSSRuleList getMatchedCSSRules(Element elt, String pseudoElt);
    /** 
 Returns the selection object representing the selected item(s).  */
    native public Selection getSelection();
    /** 
 Returns a <code>MediaQueryList</code> object representing the specified media query string.  */
    native public MediaQueryList matchMedia(String mediaQuery);
    /** 
 Moves the current window by a specified amount.  */
    native public void moveBy(double x, double y);
    /** 
 Moves the window to the specified coordinates.  */
    native public void moveTo(double x, double y);
    native public void msCancelRequestAnimationFrame(double handle);
    native public MediaQueryList msMatchMedia(String mediaQuery);
    native public double msRequestAnimationFrame(FrameRequestCallback callback);
    native public void msWriteProfilerMark(String profilerMarkName);
    /** 
 Opens a new window.  */
    native public Object open(String url, String target, String features, Boolean replace);
    /** 
 Provides a secure means for one window to send a string of data to another window, which need not be within the same domain as the first.  */
    native public void postMessage(Object message, String targetOrigin, Object ports);
    /** 
 Opens the Print Dialog to print the current document.  */
    native public void print();
    /** 
 Returns the text entered by the user in a prompt dialog.  */
    native public String prompt(String message, String _default);
    /** 
 Releases the window from trapping events of a specific type.  */
    native public void releaseEvents();
    native public double requestAnimationFrame(FrameRequestCallback callback);
    /** 
 Resizes the current window by a certain amount.  */
    native public void resizeBy(double x, double y);
    /** 
 Dynamically resizes window.  */
    native public void resizeTo(double x, double y);
    /** 
 Scrolls the window to a particular place in the document.  */
    native public void scroll(double x, double y);
    /** 
 Scrolls the document in the window by the given amount.  */
    native public void scrollBy(double x, double y);
    /** 
 Scrolls to a particular set of coordinates in the document.  */
    native public void scrollTo(double x, double y);
    native public WebKitPoint webkitConvertPointFromNodeToPage(Node node, WebKitPoint pt);
    native public WebKitPoint webkitConvertPointFromPageToNode(Node node, WebKitPoint pt);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureChange type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureDoubleTap type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureEnd type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureHold type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureStart type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureTap type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSInertiaStart type, java.util.function.Function<MSGestureEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerCancel type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerDown type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerEnter type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerLeave type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerMove type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerOut type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerOver type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerUp type, java.util.function.Function<MSPointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.abort type, java.util.function.Function<UIEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.afterprint type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.beforeprint type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.beforeunload type, java.util.function.Function<BeforeUnloadEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.blur type, java.util.function.Function<FocusEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.canplay type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.canplaythrough type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.change type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.click type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.compassneedscalibration type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.contextmenu type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dblclick type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.devicemotion type, java.util.function.Function<DeviceMotionEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.deviceorientation type, java.util.function.Function<DeviceOrientationEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.drag type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dragend type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dragenter type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dragleave type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dragover type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.dragstart type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.drop type, java.util.function.Function<DragEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.durationchange type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.emptied type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.ended type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.focus type, java.util.function.Function<FocusEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.hashchange type, java.util.function.Function<HashChangeEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.input type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.keydown type, java.util.function.Function<KeyboardEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.keypress type, java.util.function.Function<KeyboardEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.keyup type, java.util.function.Function<KeyboardEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.load type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.loadeddata type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.loadedmetadata type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.loadstart type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.message type, java.util.function.Function<MessageEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mousedown type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mouseenter type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mouseleave type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mousemove type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mouseout type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mouseover type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mouseup type, java.util.function.Function<MouseEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.mousewheel type, java.util.function.Function<MouseWheelEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.offline type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.online type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.orientationchange type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pagehide type, java.util.function.Function<PageTransitionEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pageshow type, java.util.function.Function<PageTransitionEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pause type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.play type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.playing type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.popstate type, java.util.function.Function<PopStateEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.progress type, java.util.function.Function<ProgressEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.ratechange type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.readystatechange type, java.util.function.Function<ProgressEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.reset type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.resize type, java.util.function.Function<UIEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.scroll type, java.util.function.Function<UIEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.seeked type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.seeking type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.select type, java.util.function.Function<UIEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.stalled type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.storage type, java.util.function.Function<StorageEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.submit type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.suspend type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.timeupdate type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.unload type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.volumechange type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.waiting type, java.util.function.Function<Event,Object> listener, Boolean useCapture);
    native public Window $get(double index);
    public static Window prototype;
    public Window(){}
    native public void clearInterval(double handle);
    native public void clearTimeout(double handle);
    native public double setInterval(Object handler, Object timeout, Object... args);
    native public double setTimeout(Object handler, Object timeout, Object... args);
    /** 
 Cancels the repeated execution set using <code>setImmediate</code>.  */
    native public void clearImmediate(double handle);
    native public void msClearImmediate(double handle);
    native public double msSetImmediate(Object expression, Object... args);
    /** 
 Executes a function after the browser has finished other heavy tasks  */
    native public double setImmediate(Object expression, Object... args);
    /** 
 Returns a storage object for storing data within a single page session.  */
    public Storage sessionStorage;
    /** 
 Returns a reference to the local storage object used to store data that may only be accessed by the origin that created it.  */
    public Storage localStorage;
    /** 
 Returns a reference to the console object providing access to the browser's debugging console.  */
    public Console console;
    public java.util.function.Function<PointerEvent,Object> onpointercancel;
    public java.util.function.Function<PointerEvent,Object> onpointerdown;
    public java.util.function.Function<PointerEvent,Object> onpointerenter;
    public java.util.function.Function<PointerEvent,Object> onpointerleave;
    public java.util.function.Function<PointerEvent,Object> onpointermove;
    public java.util.function.Function<PointerEvent,Object> onpointerout;
    public java.util.function.Function<PointerEvent,Object> onpointerover;
    public java.util.function.Function<PointerEvent,Object> onpointerup;
    public java.util.function.Function<WheelEvent,Object> onwheel;
    native public void addEventListener(jsweet.util.StringTypes.pointercancel type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerdown type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerenter type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerleave type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointermove type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerout type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerover type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.pointerup type, java.util.function.Function<PointerEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(jsweet.util.StringTypes.wheel type, java.util.function.Function<WheelEvent,Object> listener, Boolean useCapture);
    native public void addEventListener(String type, EventListener listener, Boolean useCapture);
    public IDBFactory indexedDB;
    public IDBFactory msIndexedDB;
    native public String atob(String encodedString);
    native public String btoa(String rawString);
    /** 
 Displays an alert dialog.  */
    native public void alert();
    /** 
 Displays a dialog with a message that the user needs to respond to.  */
    native public Boolean confirm();
    /** 
 Gets computed style for the specified element. Computed style indicates the computed values of all CSS properties of the element.  */
    native public CSSStyleDeclaration getComputedStyle(Element elt);
    native public CSSRuleList getMatchedCSSRules(Element elt);
    /** 
 Moves the current window by a specified amount.  */
    native public void moveBy(double x);
    /** 
 Moves the current window by a specified amount.  */
    native public void moveBy();
    /** 
 Moves the window to the specified coordinates.  */
    native public void moveTo(double x);
    /** 
 Moves the window to the specified coordinates.  */
    native public void moveTo();
    /** 
 Opens a new window.  */
    native public Object open(String url, String target, String features);
    /** 
 Opens a new window.  */
    native public Object open(String url, String target);
    /** 
 Opens a new window.  */
    native public Object open(String url);
    /** 
 Opens a new window.  */
    native public Object open();
    /** 
 Provides a secure means for one window to send a string of data to another window, which need not be within the same domain as the first.  */
    native public void postMessage(Object message, String targetOrigin);
    /** 
 Returns the text entered by the user in a prompt dialog.  */
    native public String prompt(String message);
    /** 
 Returns the text entered by the user in a prompt dialog.  */
    native public String prompt();
    /** 
 Resizes the current window by a certain amount.  */
    native public void resizeBy(double x);
    /** 
 Resizes the current window by a certain amount.  */
    native public void resizeBy();
    /** 
 Dynamically resizes window.  */
    native public void resizeTo(double x);
    /** 
 Dynamically resizes window.  */
    native public void resizeTo();
    /** 
 Scrolls the window to a particular place in the document.  */
    native public void scroll(double x);
    /** 
 Scrolls the window to a particular place in the document.  */
    native public void scroll();
    /** 
 Scrolls the document in the window by the given amount.  */
    native public void scrollBy(double x);
    /** 
 Scrolls the document in the window by the given amount.  */
    native public void scrollBy();
    /** 
 Scrolls to a particular set of coordinates in the document.  */
    native public void scrollTo(double x);
    /** 
 Scrolls to a particular set of coordinates in the document.  */
    native public void scrollTo();
    native public void addEventListener(jsweet.util.StringTypes.MSGestureChange type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureDoubleTap type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureEnd type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureHold type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureStart type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSGestureTap type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSInertiaStart type, java.util.function.Function<MSGestureEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerCancel type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerDown type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerEnter type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerLeave type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerMove type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerOut type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerOver type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.MSPointerUp type, java.util.function.Function<MSPointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.abort type, java.util.function.Function<UIEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.afterprint type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.beforeprint type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.beforeunload type, java.util.function.Function<BeforeUnloadEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.blur type, java.util.function.Function<FocusEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.canplay type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.canplaythrough type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.change type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.click type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.compassneedscalibration type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.contextmenu type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dblclick type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.devicemotion type, java.util.function.Function<DeviceMotionEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.deviceorientation type, java.util.function.Function<DeviceOrientationEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.drag type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dragend type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dragenter type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dragleave type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dragover type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.dragstart type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.drop type, java.util.function.Function<DragEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.durationchange type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.emptied type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.ended type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.focus type, java.util.function.Function<FocusEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.hashchange type, java.util.function.Function<HashChangeEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.input type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.keydown type, java.util.function.Function<KeyboardEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.keypress type, java.util.function.Function<KeyboardEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.keyup type, java.util.function.Function<KeyboardEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.load type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.loadeddata type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.loadedmetadata type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.loadstart type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.message type, java.util.function.Function<MessageEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mousedown type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mouseenter type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mouseleave type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mousemove type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mouseout type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mouseover type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mouseup type, java.util.function.Function<MouseEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.mousewheel type, java.util.function.Function<MouseWheelEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.offline type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.online type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.orientationchange type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pagehide type, java.util.function.Function<PageTransitionEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pageshow type, java.util.function.Function<PageTransitionEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pause type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.play type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.playing type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointercancel type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerdown type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerenter type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerleave type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointermove type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerout type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerover type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.pointerup type, java.util.function.Function<PointerEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.popstate type, java.util.function.Function<PopStateEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.progress type, java.util.function.Function<ProgressEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.ratechange type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.readystatechange type, java.util.function.Function<ProgressEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.reset type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.resize type, java.util.function.Function<UIEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.scroll type, java.util.function.Function<UIEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.seeked type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.seeking type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.select type, java.util.function.Function<UIEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.stalled type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.storage type, java.util.function.Function<StorageEvent,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.submit type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.suspend type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.timeupdate type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.unload type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.volumechange type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.waiting type, java.util.function.Function<Event,Object> listener);
    native public void addEventListener(jsweet.util.StringTypes.wheel type, java.util.function.Function<WheelEvent,Object> listener);
    native public void addEventListener(String type, EventListener listener);
    native public double setInterval(Object handler);
    native public double setTimeout(Object handler);
    native public void addEventListener(String type, EventListenerObject listener, Boolean useCapture);
    native public void addEventListener(String type, EventListenerObject listener);
    native public void onerror(java.lang.String message, java.lang.String filename, double lineno, double colno, jsweet.lang.Error error);
    native public void onerror(java.lang.String message, java.lang.String filename, double lineno, double colno);
    native public void onerror(java.lang.String message, java.lang.String filename, double lineno);
    native public void onerror(java.lang.String message, java.lang.String filename);
    native public void onerror(java.lang.String message);
    /** From Iterable, to allow foreach loop (do not use directly). */
    @jsweet.lang.Erased
    native public java.util.Iterator<Window> iterator();
}

