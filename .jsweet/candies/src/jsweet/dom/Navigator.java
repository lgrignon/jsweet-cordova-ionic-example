package jsweet.dom;
/**  <p>The <code><strong>Navigator</strong></code> interface represents the state and the identity of the user agent. It allows scripts to query it and to register themselves to carry on some activities.</p> <p>A <code>Navigator</code> object can be retrieved using the read-only <code>Window.navigator</code> property.</p>  */
@jsweet.lang.Extends({NavigatorID.class,NavigatorOnLine.class,NavigatorContentUtils.class,NavigatorStorageUtils.class,NavigatorGeolocation.class,MSNavigatorDoNotTrack.class,MSFileSaver.class})
public class Navigator extends Object {
    public String appCodeName;
    public String appMinorVersion;
    public String browserLanguage;
    public double connectionSpeed;
    /** 
 Returns a boolean indicating whether cookies are enabled in the browser or not.  */
    public Boolean cookieEnabled;
    public String cpuClass;
    public String language;
    public double maxTouchPoints;
    public MSMimeTypesCollection mimeTypes;
    public Boolean msManipulationViewsEnabled;
    public double msMaxTouchPoints;
    public Boolean msPointerEnabled;
    public MSPluginsCollection plugins;
    public Boolean pointerEnabled;
    public String systemLanguage;
    public String userLanguage;
    public Boolean webdriver;
    native public Gamepad[] getGamepads();
    native public Boolean javaEnabled();
    native public void msLaunchUri(String uri, MSLaunchUriCallback successCallback, MSLaunchUriCallback noHandlerCallback);
    native public void addEventListener(String type, EventListener listener, Boolean useCapture);
    public static Navigator prototype;
    public Navigator(){}
    public String appName;
    public String appVersion;
    public String platform;
    public String product;
    /** 
 Returns the build number of the current browser (e.g., &quot;20060909&quot;).  */
    public String productSub;
    public String userAgent;
    /** 
 Returns the vendor name of the current browser (e.g., &quot;Netscape6&quot;).  */
    public String vendor;
    /** 
 Returns the vendor version number (e.g. &quot;6.1&quot;).  */
    public String vendorSub;
    public Boolean onLine;
    /** 
 Returns a <code>Geolocation</code> object allowing accessing the location of the device.  */
    public Geolocation geolocation;
    native public Boolean confirmSiteSpecificTrackingException(ConfirmSiteSpecificExceptionsInformation args);
    native public Boolean confirmWebWideTrackingException(ExceptionInformation args);
    native public void removeSiteSpecificTrackingException(ExceptionInformation args);
    native public void removeWebWideTrackingException(ExceptionInformation args);
    native public void storeSiteSpecificTrackingException(StoreSiteSpecificExceptionsInformation args);
    native public void storeWebWideTrackingException(StoreExceptionsInformation args);
    native public Boolean msSaveBlob(Object blob, String defaultName);
    native public Boolean msSaveOrOpenBlob(Object blob, String defaultName);
    native public void msLaunchUri(String uri, MSLaunchUriCallback successCallback);
    native public void msLaunchUri(String uri);
    native public void addEventListener(String type, EventListener listener);
    native public Boolean msSaveBlob(Object blob);
    native public Boolean msSaveOrOpenBlob(Object blob);
    native public void addEventListener(String type, EventListenerObject listener, Boolean useCapture);
    native public void addEventListener(String type, EventListenerObject listener);
}

