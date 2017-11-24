package p.hin.ec.common;

public final class Constant {
    //api前缀
    public static final String API_PREFIX = "api";

    //根据不同类型请求获取items
    public static final int GET_ITEMS_SEARCH = 0;
    public static final int GET_ITEMS_CATEGORY = 1;
    public static final int GET_ITEMS_FAVORITE = 2;
    public static final int GET_ITEMS_LATEST = 3;
    public static final int GET_ITEMS_UPLOADER = 4;

    //category的ID
    public static final int CATEGORY_DESK = 0;
    public static final int CATEGORY_SHELF = 1;
    public static final int CATEGORY_LAMP = 2;
    public static final int CATEGORY_DECORATION = 3;
    public static final int CATEGORY_KITCHEN = 4;
    public static final int CATEGORY_MISC = 5;
    public static final int CATEGORY_ALL = 6;

    //用户注册反馈状态
    public static final int USER_REGISTER_SUCCESS = 0;
    public static final int USER_REGISTER_USERNAME_DUPLICATE = 1;
    public static final int USER_REGISTER_EMAIL_DUPLICATE = 2;

    //用户登录反馈状态
    public static final int USER_LOGIN_SUCCESS = 0;
    public static final int USER_LOGIN_NOT_MATCH = 1;

    //用户注销反馈状态
    public static final int USER_LOGOUT_SUCCESS = 0;

    //图片上传状态
    public static final int UPLOAD_PIC_SUCCESS = 0;
    public static final int UPLOAD_PIC_FAILED = 1;

    //item默认值
    public static final int ITEM_ID_DEFAULT = -1;
    public static final int ITEM_STATUS_NORMAL = 0;
    public static final int ITEM_STATUS_DELETED = 1;

    //user 类型
    public static final int USER_TYPE_VISTOR = 0;
    public static final int USER_TYPE_BUYER = 1;
    public static final int USER_TYPE_UPLOADER = 2;

    //order状态
    public static final int ORDER_CART = 0;
    public static final int ORDER_ORDERED = 1;
    public static final int ORDER_VERIFY_SUCCESS = 2;
    public static final int ORDER_VERIFY_FAILED = 3;
    public static final int ORDER_CONFIRMED = 4;
    public static final int ORDER_REFUNDED = 5;
}
