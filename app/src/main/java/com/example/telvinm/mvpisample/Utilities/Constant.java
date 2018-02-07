package com.example.telvinm.mvpisample.Utilities;

/**
 * Created  on 01-03-2017.
 */

public class Constant
{
    public static final long DIALOG_TIME_OUT = 2000;
    public static final String HEBREW_CODE = "iw";
    public static final String ENGLISH_CODE = "en";
    public static final String STOCK_EXISTING = "Existing";
    public static final String ITEM_HIDDEN = "hidden";
    public static final String SUCCESS = "Success";
    public static final String FAILED = "FAILED";
    public static final String API_ERROR = "API ERROR";
    public static final String NOTIFICATION_DATA = "SupplierData";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer";
    public static final Integer GUEST_CLIENT_ID = -999;
    public static final String GUEST_USERNAME = "guest@gmail.com";
    public static final String GUEST_PASSWORD = "guest123";
    public static final String REGISTER = "Register";
    public static final String FORGOT_PASSWORD = "Forgot password";
    public static final String HOMEPAGE = "Homepage";

    public interface LoginResponseStatus
    {
        String INVALID_PASSWORD = "INVALID_PASSWORD";
        String INVALID_USERNAME = "INVALID_USERNAME";
        String INVALID_EMAIL = "INVALID_EMAIL";
        String INVALID_EMAIL_OR_PASSWORD = "INVALID_USERNAMEORPASSWORD";
        String SUCCESS = "SUCCESS";
    }

    public interface SupplierRequestStatus
    {
        Integer EMPTY = 0;
        Integer APPROVED = 1;
        Integer REJECTED = 2;
        Integer PENDING = 3;
    }


    public interface API_ENDPOINTS
    {
        String LOGIN = "Login/AuthenticateLogin";
        String RECOVER_PASSWORD = "ForgotPassword/GetPassword";
        String SUPPLIER_DATA = "Supplier/GetSupplierData";
        String CATEGORY_LIST = "Supplier/SupplierCategoryList";
        String LOAD_DEFINITIONS = "AdminDefinition/LoadAdminDefinitions";
        String SUPPLIER_ITEM_LIST = "ItemList/GetSupplierItemList";
        String REGISTER = "ClientDetails/AddClientDetails";
        String UPDATE_PROFILE = "ClientDetails/UpdateClientProfileDetails";
        String GET_PROFILE_DATA = "ClientDetails/GetClientProfileData";
        String ITEM_DETAIL = "ItemDisplay/LoadItemDetails";
        String CLIENT_REQUEST = "ClientDetails/AddClientRequest";
        String ITEM_CATEGORY_LIST = "itemlist/getcategorylist";
        String GET_ABOUT_US = "About/LoadDetails";
        String GET_CONTACT_US = "Contact/LoadDetails";
        String GET_BRANCH_USERS = "ClientDetails/GetBranchUsersProfileData";
        String GET_BRANCH_USER_PROFILE_DATA = "ClientDetails/GetBranchUsersProfileData";
        String UPDATE_BRANCH_USER_PROFILE_DATA = "ClientDetails/UpdateBranchUserProfileDetails";
        String ADD_BRANCH_USER = "ClientDetails/AddBranchUsersDetails";
        String GET_BRANCH_USER_LIST = "ClientDetails/GetBranchUsersDetailsList";
        String GET_SUPPLIER_ITEM_PRICE = "Order/GetSupplierItemPrice";
        String ADD_TO_CART = "Order/SaveShoppingCartDetails";
        String GET_CART_LIST = "Order/GetShoppingCartList";
        String DELETE_CART_ITEM = "Order/DeleteShoppingCartItem";
        String PROCESS_ORDER = "Order/ProcessOrderDetails";
        String ORDER_HISTORY = "Order/GetOrderHistoryList";
        String ORDERED_ITEM_LIST = "Order/GetClientwiseSupplierOrderdItemList";
        String REORDER_ITEM = "Order/ItemReOrdering";
        String GET_CART_COUNT = "Order/GetShoppingCartCount";
        String UPDATE_FCM_TOKEN = "ClientDetails/UpdateFCMToken";
    }

    public interface SERVER_KEYS
    {

        String USERNAME = "username";
        String PASSWORD = "password";
        String EMAIL = "Email";
        String CLIENT_ID = "ClientId";
        String SUPPLIER_ID = "SupplierId";
        String PAGE = "Page";
        String SEARCH_KEY = "SearchKey";
        String CLIENT_DETAILS_DATA = "jsonClientDetailsData";
        String USER_DATA = "jsonUserData";
        String ITEM_ID = "ItemId";
        String CLIENT_REQUEST_DATA = "jsonClientReuestData";
        String USER_ID = "userID";
        String FILTER = "Filter";
        String ID = "Id";
        String BRANCH_USER_ID = "branchUserID";
        String ADD_BRANCH_USER_BODY = "jsonClientDetailsData";
        String PARENT_CLIENT_ID = "parentClientId";
        String CLIENT_TYPE = "clientType";
        String ITEM_QUANTITY = "itemQTY";
        String PRICE_ITEM_ID = "itemID";
        String PRICE_SUPPLIER_ID = "supplierID";
        String PRICE_CLIENT_ID = "clientID";
        String CART_ID = "CartID";
        String ORDER_ID = "orderID";
        String ITEM_CLIENT_ID = "clientid";
        String PARENT_ID = "parentID";
    }

    public interface FRAGMENT_TAG
    {
        String ALLSUPPLIERS = "ALL_SUPPLIERS";
    }

    public interface CLIENT_TYPE
    {
        Integer BRANCH_USER = 5;
        Integer GUEST_USER = 999;
    }

    public interface SUPPLIER_TYPE
    {
        Integer DEMO = 4;
    }

    public interface API_CUSTOM_CODE
    {
        Integer SUCCESS = 40;
        Integer ALREADY_REGISTERED_EMAIL = 42;
        String SUCCESS_STRING = "40";
        String ALREADY_REGISTERED_EMAIL_STRING = "42";
    }

    public interface DATE_FILTER
    {
        String ALL = "ALL";
        String LAST_WEEK = "LAST_WEEK";
        String LAST_MONTH = "LAST_MONTH";
        String PREVIOUS_SIX_WEEK = "PREVIOUS_SIX_WEEK";
    }
}
