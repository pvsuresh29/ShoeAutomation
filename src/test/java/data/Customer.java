package data;

/**
 * Created by aaronbriel on 9/22/16.
 */
public class Customer {

    public String firstName;
    public String lastName;
    public String address1;
    public String address2;
    public String country;
    public String state;
    public String city;
    public String zip;
    public String phone;
    public String phoneType;
    public String email = "T@e.com";
    public String ccNum = "411";
    public String cvn = "1234";
    public String paypalUser = "Tst@tireco.com";
    public String paypalPass = "dtc1";
    public String paypalAddress;

    private enum CustomerType {
        DEFAULT_CUSTOMER_AZ,
        DEFAULT_CUSTOMER_FL,
        DEFAULT_CUSTOMER_LA,
        DEFAULT_CUSTOMER_OH,
        DEFAULT_CUSTOMER_TX,
        PAYPAL_CUSTOMER_AZ,
        PAYPAL_CUSTOMER_OH;

        public static CustomerType customerForName(String customer) throws IllegalArgumentException {
            for(CustomerType c: values()) {
                if(c.toString().equalsIgnoreCase(customer)) {
                    return c;
                }
            }
            throw customerNotFound(customer);
        }

        private static IllegalArgumentException customerNotFound(String outcome) {
            return new IllegalArgumentException(("Invalid customer [" + outcome + "]"));
        }
    }

    public Customer() { }

    public Customer getCustomer(String custType) {
        CustomerType customerType = CustomerType.customerForName(custType);
        Customer customer = new Customer();

        switch(customerType) {
            case DEFAULT_CUSTOMER_AZ:
            	 customer.firstName = "TEST";
                 customer.lastName = "TEST";
                customer.address1 = "E 67 Elwood St";
                customer.address2 = "";
                customer.country = "United States";
                customer.state = "Arizona";
                customer.city = "Phoenix";
                customer.zip = "85040";
                customer.phone = "666-666-6666";
                customer.phoneType = "Home";
                customer.email = email;
                customer.ccNum = ccNum;
                customer.cvn = cvn;
                break;
            case DEFAULT_CUSTOMER_FL:
            	 customer.firstName = "TEST";
                 customer.lastName = "TEST";
                customer.address1 = "3700 E Fiske Blvd";
                customer.address2 = "";
                customer.country = "United States";
                customer.state = "Rockledge";
                customer.city = "Florida";
                customer.zip = "32955";
                customer.phone = "888-888-8888";
                customer.phoneType = "Home";
                customer.email = email;
                customer.ccNum = ccNum;
                customer.cvn = cvn;
                break;
            case DEFAULT_CUSTOMER_LA:
            	 customer.firstName = "TEST";
                 customer.lastName = "TEST";
                customer.address1 = "2018 Ambassador Caffery Pkwy";
                customer.address2 = "";
                customer.country = "United States";
                customer.state = "Louisiana";
                customer.city = "Lafayette";
                customer.zip = "70506";
                customer.phone = "888-888-8888";
                customer.phoneType = "Home";
                customer.email = email;
                customer.ccNum = ccNum;
                customer.cvn = cvn;
                break;
            case DEFAULT_CUSTOMER_OH:
            	 customer.firstName = "TEST";
                 customer.lastName = "TEST";
                customer.address1 = "1421 Saint Clair Ave NE";
                customer.address2 = "";
                customer.country = "United States";
                customer.state = "Ohio";
                customer.city = "Cleveland";
                customer.zip = "44114";
                customer.phone = "555-555-5555";
                customer.phoneType = "Home";
                customer.email = email;
                customer.ccNum = ccNum;
                customer.cvn = cvn;
                break;
            case DEFAULT_CUSTOMER_TX:
                customer.firstName = "TEST";
                customer.lastName = "TEST";
                customer.address1 = "3301 Palmer Hwy";
                customer.address2 = "";
                customer.country = "United States";
                customer.state = "Texas";
                customer.city = "Texas City";
                customer.zip = "77590";
                customer.phone = "777-777-7777";
                customer.phoneType = "Home";
                customer.email = email;
                customer.ccNum = ccNum;
                customer.cvn = cvn;
                break;
            case PAYPAL_CUSTOMER_AZ:
                customer.paypalUser = paypalUser;
                customer.paypalPass = paypalPass;
                customer.paypalAddress = "20225 ";
                break;
            case PAYPAL_CUSTOMER_OH:
                customer.paypalUser = paypalUser;
                customer.paypalPass = paypalPass;
                customer.paypalAddress = "10813 ";
                break;
        }
        return customer;
    }

}
