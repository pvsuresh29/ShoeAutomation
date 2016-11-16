package common;

/**
 * Created by Suresh Venkata on 9/17/16.
 */

public class Config {

    private static final String BROWSER = System.getProperty("browser", Constants.CHROME_BROWSER);
    private static final String IS_REMOTING = System.getProperty("isRemoting", "false");
    private static final String IS_SAUCELABS = System.getProperty("isSaucelabs", "false");
    private static final String HTTP = "http://";
    private static final String SITE_REGION = System.getProperty("siteRegion", Constants.DTD);
    private static final String BASE_URL = System.getProperty("baseUrl", "localhost");
    private static final String DATA_SET = System.getProperty("dataSet", Constants.QA);

    public static String getBaseUrl() {
        return HTTP + BASE_URL;
    }

    public static String getSiteRegion() {
        return SITE_REGION;
    }

    public static String getBrowser() {
        return BROWSER;
    }

    public static Boolean getIsRemoting() {
        return Boolean.parseBoolean(IS_REMOTING);
    }

    public static Boolean getIsSaucelabs() {
        return Boolean.parseBoolean(IS_SAUCELABS);
    }

    public static String getSaucelabsBrowser() {
        return System.getenv("SELENIUM_BROWSER");
    }

    public static String getSaucelabsBrowserVersion() {
        return System.getenv("SELENIUM_VERSION");
    }

    public static String getSaucelabsPlatform() {
        return System.getenv("SELENIUM_PLATFORM");
    }

    public static String getDataSet() {
        return DATA_SET;
    }

    public static String getDefaultStore() {
        String store = null;
        if (getSiteRegion().equalsIgnoreCase(Constants.DT)) {
            if (getDataSet().equalsIgnoreCase(Constants.STG)) {
                store = Constants.DT_STG_DEFAULT_STORE;
            } else {
                store = Constants.DT_QA_DEFAULT_STORE;
            }
        } else if (getSiteRegion().equalsIgnoreCase(Constants.AT)) {
            if (getDataSet().equalsIgnoreCase(Constants.STG)) {
                store = Constants.AT_STG_DEFAULT_STORE;
            } else {
                store = Constants.AT_QA_DEFAULT_STORE;
            }
        }
        return store;
    }

    public static String getDefaultStoreCity() {
        String store = null;
        if (getSiteRegion().equalsIgnoreCase(Constants.DT)) {
            if (getDataSet().equalsIgnoreCase(Constants.STG)) {
                store = Constants.DT_STG_DEFAULT_STORE_CITY;
            } else {
                store = Constants.DT_QA_DEFAULT_STORE_CITY;
            }
        } else if (getSiteRegion().equalsIgnoreCase(Constants.AT)) {
            if (getDataSet().equalsIgnoreCase(Constants.STG)) {
                store = Constants.AT_STG_DEFAULT_STORE_CITY;
            } else {
                store = Constants.AT_QA_DEFAULT_STORE_CITY;
            }
        }
        return store;
    }

    public static String getSaucelabsUrl() {
        String USERNAME = System.getenv("SAUCE_USER");
        String ACCESS_KEY = System.getenv("SAUCE_KEY");
        return "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    }
}
