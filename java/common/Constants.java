package common;

/**
 * Created by Suresh Venkata on 9/17/16.
 */

public class Constants {

    public static final String BROWSER_PROP_KEY = "browser";
    public static final String CONFIG_FILE 		= "config.properties";
    public static final int ANIMATION_WAIT = 1000;
    public static final int ANIMATION_LONG_WAIT = 2000;
    public static final int VERY_SHORT_WAIT = 5;
    public static final int SHORT_WAIT = 10;
    public static final int DEFAULT_WAIT = 30;
    public static final int PAGE_WAIT = 120;

    public static final String QA = "qa";
    public static final String DEV = "dev";
    public static final String STG = "stg";
    public static final String PROD = "prod";

    public static final String DT_QA_DEFAULT_STORE_CITY = "flagstaff";
    public static final String DT_STG_DEFAULT_STORE_CITY = "eugene";
    public static final String DT_QA_DEFAULT_STORE = "AZF 01";
    public static final String DT_STG_DEFAULT_STORE = "ORP 02";
    public static final String AT_QA_DEFAULT_STORE_CITY = "redding";
    public static final String AT_STG_DEFAULT_STORE_CITY = "victorville";
    public static final String AT_QA_DEFAULT_STORE = "CAN 19";
    public static final String AT_STG_DEFAULT_STORE = "CAL 02";

    public static final String FIREFOX_BROWSER = "FIREFOX";
    public static final String CHROME_BROWSER = "CHROME";
    public static final String IE_BROWSER = "IE";
    public static final String SAFARI_BROWSER = "SAFARI";

    public static final String IE_REMOTE = "http://URL";
    public static final String CHROME_REMOTE = "http:URL";//removed URLS;
    public static final String FIREFOX_REMOTE = "http:URL ";
    public static final String SAFARI_REMOTE = "http:URL";

    public static final String DTD = "dtd";
    public static final String DT = "dt";
    public static final String AT = "at";

    public static final String UPS_FREE = "UPS Ground - Free";
    public static final String UPS_SECONDDAY = "UPS Second Day Air";
    public static final String UPS_NEXTDAY = "UPS Next Day Air";

    public static final String PAYPAL = "paypal";
    public static final String DEFAULT = "default";
    public static final String WITH_APPOINTMENT = "with appointment";
    public static final String WITHOUT_APPOINTMENT = "without appointment";

    public static final String ORDER_PAGE = "order";
    public static final String HOMEPAGE = "homepage";
    public static final String MYVEHICLES = "my vehicles";
    public static final String HEADER = "header";

    public static final String SHOP_BY_VEHICLE = "Vehicle";
    public static final String SHOP_BY_SIZE = "Size";
    public static final String SHOP_BY_BRAND = "Brand";

    public static final String TIRE = "Tire";
    public static final String WHEEL = "Wheel";

    public static final String VEHICLE_SEARCH = "Vehicle Search";
    public static final String TIRE_SIZE_SEARCH = "Tire Size Search";
    public static final String WHEEL_SIZE_SEARCH = "Wheel Size Search";

    public static final String YEAR = "Year";
    public static final String MAKE = "Make";
    public static final String MODEL = "Model";
    public static final String TRIM = "Trim";
    public static final String ASSEMBLY = "Assembly";
    public static final String NONE = "none";
    public static final String CLOSE = "close";

    public static final String SECTION_WIDTH = "Section Width";
    public static final String ASPECT_RATIO = "Aspect Ratio";
    public static final String WHEEL_DIAMETER = "Wheel Diameter";

    public static final String STAGGERED = "Staggered";
    public static final String NONSTAGGERED = "Non Staggered";

    public static final String TIRES_HEADER = "Results for Tires";
    public static final String WHEELS_HEADER = "Results for Wheels";

    public static final String ENVIRONMENTAL_FEE = "Environmental Fee (State Required)";
    public static final String TAX = "Tax";

	public static final String INSTOCK = "In Stock";
    public static final String DEFAULT_QUANTITY = "4";

    public static final String SEARCH = "Search";
    public static final String CONTINUE = "Continue";
    public static final String STORE_LOCATOR_HEADER = "Store Locator";

    public static final String CUSTOMER_INFO_URL = "/en/checkout/customer-info";
    public static final String STORE_LOCATOR_URL = "/en/store-locator";
    
    public static final String DISCOUNT_TIRE_STORE = "Discount Tire Store ";
    public static final String MAKE_THIS_MY_STORE = "Make this my store";
    public static final String CURRENT_STORE_LABEL = "current store";

    public static final String ZERO_DOLLARS = "$0";
    public static final String SUBTOTAL = "Subtotal";
    
    public static final String ITEM_REMOVED_MESSAGE = "Product has been removed from your cart.";

    public static final String RESERVATION_CONFIRMATION_MESSAGE = "Your order has been placed successfully.";
    public static final String ORDER_CONFIRMATION_MESSAGE = "Success! Thank you for trusting Discount Tire Direct";
    public static final String SEND_TO_PHONE_CONFIRMATION_MESSAGE =  "The information for this location will be sent to your phone";

    public static final String MICHELIN = "michelin";

    public static final String GREEN_COLOR = "rgba(70, 186, 43, 1)";
    public static final String GREY_COLOR  = "rgba(153, 153, 153, 1)";
    public static final String BLUE_COLOR  = "rgba(0, 174, 239, 1)";

    public static final String BACKGROUND_COLOR = "background-color";

    public static final String GOOD = "GOOD";
    public static final String BETTER = "BETTER";
    public static final String BEST = "BEST";

    public static final String BRAND = "brand";
    public static final String PRICE = "price";
    public static final String PRODUCT = "product";

    public static final String PRICE__NOT_DISPLAYED = "Price not displayed.";

    public static final Integer COMPARE_LOW = 1;
    public static final Integer COMPARE_MEDIUM = 2;
    public static final Integer COMPARE_HIGH = 3;

    public static final String TIRES = "TIRES";
    public static final String WHEELS = "WHEELS";

    public static final String SPECIAL_ORDER_MESSAGE = "You selected product that is \"Special Order\". " +
            "A representative from the store you selected will verify product availability and contact you " +
            "(within 1 business day) regarding installation.";
    public static final String CALL_US_MESSAGE = "Call us at 800-589-6789";

    public static final String SESSION_COOKIE_NAME = "JSESSIONID";
}
