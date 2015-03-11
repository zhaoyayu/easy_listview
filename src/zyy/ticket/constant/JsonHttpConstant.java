package zyy.ticket.constant;

public class JsonHttpConstant {

	/** json成功和错误返回 **/
	// 网络访问成功
	public static String JSONDATA_RETURN_SUCESS = "200";
	// 服务器返回成功
	public static String JSONDATA_SERVER_RETURN_SUCESS = "0";
	// 服务器异常
	public static String JSONDATA_RETURN_ERRO_SERVER = "500";
	// 服务端日常维护
	public static String JSONDATA_RETURN_ERRO_MAINTAIN = "201";
	// 请求参数不符合
	public static String JSONDATA_RETURN_ERRO_PARAMETER = "202";
	// 非法操作
	public static String JSONDATA_RETURN_ERRO_OPERATE = "203";
	// 扩展错误信息
	public static String JSONDATA_RETURN_ERRO_OTHER = "204";
	// 登陆超时
	public static String JSONDATA_RETURN_ERRO_TIMEOUT = "401";

	/** 请求json数据地址 **/
	/** 开发地址 */
	// public static String jsonUrl = "http://192.168.40.50:8380";
	/** 测试地址 */
	// public static String jsonUrl = "http://192.168.10.85:8180";
	/** 大鹏本机 */
	// public static String jsonUrl = "http://192.168.40.13:8080";
	// 公网地址
	public static String jsonUrl = "http://api.bapp.piao.cn";

	/** 查询版本升级地址 **/
	public static final String updateVersionUrl = "/common/fetch_app_version";

	/** 请求演出列表地址 **/
	public static String ticketListUrl = "/ticket/discovery";

	/** 商户列表地址 **/
	public static String businessListUrl = "/user/merchant_list";

	/** 城市列表地址 **/
	public static String cityListUrl = "";

	/** 附近票列表地址 **/
	public static String aroundTicketListUrl = "/ticket/nearby";

	/** 商户的票列表地址 **/
	public static String ticketSeatListUrl = "/ticket/merchants";

	/** 项目分类列表地址 **/
	public static String showTypeListUrl = "/common/fetch_categories";

	/** 场馆列表地址 **/
	public static String showVenueListUrl = "/common/fetch_venues";

	/** 卖家详情地址 **/
	public static String sellerDetailUrl = "/user/merchant_detail";

	/** 收货接口地址 **/
	public static String receiveTicketUrl = "/order/receive";

	/** 退款 */
	public static String refundTicketUrl = "/order/apply_refund";

	/** 取消订单地址 **/
	public static String cancelOrderUrl = "/order/cancel";

	/** 第三方登录地址 **/
	public static String loginthirdpartyUrl = "/user/login_thirdparty";

	/** 发送验证码地址 **/
	public static String sendMsgUrl = "/common/send_vcode";

	/** 注册地址 **/
	public static String registerUrl = "/user/regist";

	/** 登陆地址 **/
	public static String loginUrl = "/user/login";

	/** 修改手机号码 **/
	public static String modifyTelUrl = "/user/modify_mobile";

	/** 修改昵称 **/
	public static String modifyNicknameUrl = "/user/modify_nickname";

	/** 修改密码 **/
	public static String modifyPwdUrl = "/user/modify_password";

	/** 修改头像 **/
	public static String modifyHeadUrl = "/user/modify_user_image";

	/** 订单列表 **/
	public static String orderListUrl = "/order/list";

	/** 创建订单并支付 **/
	public static String createAndPayUrl = "/order/create_and_pay";

	/** 支付 **/
	public static String PayUrl = "/order/pay";

	/** 订单详情 **/
	public static String orderDetailUrl = "/order/detail";

	/** 投诉 **/
	public static String complaintUrl = "/order/complain";

	/** 用户信息 **/
	public static String userInfoUrl = "/user/me";

	/** 购买页面 扫码 */
	public static String scanQRUrl = "/ticket/detail";

	/** 系统消息 */
	public static String systemMsgUrl = "/common/system_message";

	/** 重置密码 */
	public static String forgetPwdUrl = "/user/reset_password";

	/** 标为已读 */
	public static String markreadMessageUrl = "/common/markread_message";

	/** 保存设备信息 */
	public static String saveDevicesInfoUrl = "/user/save_device_info";

	/** 关注场次 */
	public static String attentionPerformUrl = "/user/attention_perform";

	/** 取消关注场次 */
	public static String cancelAttentionPerformUrl = "/user/cancel_attention_perform";

	/** 关注的演出列表 */
	public static String attentionPerformListUrl = "/user/fetch_attention_perform_list";

	/** 获取卖家订单评论列表 */
	public static String merchantCommentListUrl = "/user/fetch_merchant_comment_list";

	/** 获取买家订单评论列表 */
	public static String buyerCommentListUrl = "/user/fetch_buyer_comment_list";

	/** 演出详情（场次详情） */
	public static String performDetailUrl = "/ticket/project_detail";

	/** 关注卖家 */
	public static String attentionMerchantUrl = "/user/attention_merchant";

	/** 取消关注卖家 */
	public static String cancelAttentionMerchantUrl = "/user/cancel_attention_merchant";

	/** 关注的卖家列表 */
	public static String attentionMerchantListUrl = "/user/fetch_attention_merchant_list";

	/** 评论订单 */
	public static String commentUrl = "/order/comment";

	/** 获取分享请求参数 */
	public static String shareParamsUrl = "/user/fetch_share_params";

	/** 获取买家收货地址列表参数 */
	public static String userAddressListUrl = "/user/fetch_user_address_list";

	/** <添加|修改>买家收货地址参数 */
	public static String saveAddressUrl = "/user/save_address";

	/** 删除买家收货地址参数 */
	public static String deleteAddressUrl = "/user/delete_address";

	/** 设为默认收货地址参数 */
	public static String setDefaultAddressUrl = "/user/set_default_address";

	/** 获取卖家自提地址参数 */
	public static String merchantAddrUrl = "/user/merchant_addr";

	/** 获取百度API坐标地址参数 */
	public static String baiduAPIUrl = "http://api.map.baidu.com/geoconv/v1/";

	/** 演出票列表信息 **/
	public static final int JSONDATA_TYPE_SHOW_LIST = 1001;

	/** 演出类型信息 **/
	public static final int JSONDATA_TYPE_SHOWTYPE_LIST = 1002;

	/** 商户列表信息 **/
	public static final int JSONDATA_TYPE_BUSINESS_LIST = 1003;

	/** 附近商户演出列表信息 **/
	public static final int JSONDATA_TYPE_AROUNDTICKETLIST_LIST = 1004;

	/** 票列表信息 **/
	public static final int JSONDATA_TYPE_TICKET_LIST = 1005;

	/** 关注的演出列表信息 **/
	public static final int JSONDATA_TYPE_ATTENTION_LIST = 1006;

	/** 更新app版本信息 **/
	public static final int JSONDATA_TYPE_UPDATE_VERSION = 1007;

	/** 城市列表信息 **/
	public static final int JSONDATA_TYPE_CITY_LIST = 1008;

	/** 附近的票列表信息 **/
	public static final int JSONDATA_TYPE_AROUNDTICKET_LIST = 1009;

	/** 商户的票列表信息 **/
	public static final int JSONDATA_TYPE_TICKETSEAT_LIST = 1010;

	/** 场馆信息 **/
	public static final int JSONDATA_TYPE_VENUE_LIST = 1011;

	/** 卖家详情信息 **/
	public static final int JSONDATA_TYPE_SELLER_DETAIL = 1012;

	/* 注册 */
	public static final int JSONDATA_TYPE_REGISTERUSER = 1022;

	/* 修改头像 */
	public static final int JSONDATA_TYPE_MODIFY_USER_HEADER = 1023;

	/* 修改昵称 */
	public static final int JSONDATA_TYPE_MODIFY_USER_NAME = 1024;

	/* 修改手机号 */
	public static final int JSONDATA_TYPE_MODIFY_USER_TEL = 1025;

	/* 修改密码 */
	public static final int JSONDATA_TYPE_MODIFY_USER_PWD = 1026;

	/* 登陆 */
	public static final int JSONDATA_TYPE_LOGIN = 1021;

	/* 第三方登陆 */
	public static final int JSONDATA_TYPE_LOGIN_THIRDPARTY = 1020;

	/* 发送验证码 */
	public static final int JSONDATA_TYPE_SEND_MSG = 1027;

	/* 购买页面 扫一扫 */
	public static final int JSONDATA_TYPE_SCAN = 1028;

	/* 重置密码 */
	public static final int JSONDATA_TYPE_RESET_PWD = 1029;

	/* 系统消息 */
	public static final int JSONDATA_TYPE_SYSTEM_MSG = 1051;

	/* 标为已读(系统消息) */
	public static final int JSONDATA_TYPE_READ_MSG = 1052;

	/** 订单部分 **/

	/* 获取用户信息 */
	public static final int JSONDATA_TYPE_USER_INFO = 1031;

	/* 订单列表 */
	public static final int JSONDATA_TYPE_ORDER_LIST = 1032;

	/* 收货 */
	public static final int JSONDATA_TYPE_RECEIVETICKET = 1033;

	/* 取消订单 */
	public static final int JSONDATA_TYPE_CANCELORDER = 1034;

	/* 订单详情 */
	public static final int JSONDATA_TYPE_ORDER_DETAIL = 1035;

	/* 投诉 */
	public static final int JSONDATA_TYPE_ORDER_COMPLAINT = 1036;

	/* 退款 */
	public static final int JSONDATA_TYPE_ORDER_REFUND = 1037;

	/* 支付 */
	public static final int JSONDATA_TYPE_PAY = 1038;

	/* 创建订单并支付 */
	public static final int JSONDATA_TYPE_CREATE_AND_PAY = 1039;

	/* 订单确认 */
	public static final int JSONDATA_TYPE_ORDER_SUBMIT = 1040;

	/* 重置密码(忘记密码) */
	public static final int JSONDATA_TYPE_FORGET_PWD = 1070;

	/* 保存设备信息 */
	public static final int JSONDATA_TYPE_SAVE_DEVICE_INFO = 1071;

	/** 关注场次信息 **/
	public static final int JSONDATA_TYPE_ATTENTION_PERFORM = 1072;

	/** 取消关注场次信息 **/
	public static final int JSONDATA_TYPE_CANCEL_ATTENTION_PERFORM = 1073;

	/** 演出详情（场次详情）信息 **/
	public static final int JSONDATA_TYPE_PERFORM_DETAIL = 1075;

	/** 关注卖家信息 **/
	public static final int JSONDATA_TYPE_ATTENTION_MERCHANT = 1076;

	/** 取消关注卖家 **/
	public static final int JSONDATA_TYPE_CANCEL_ATTENTION_MERCHANT = 1077;

	/** 关注的卖家列表信息 **/
	public static final int JSONDATA_TYPE_ATTENTION_MERCHANT_LIST = 1078;

	/** 获取卖家订单评论列表信息 **/
	public static final int JSONDATA_TYPE_MERCHANT_COMMENT_LIST = 1079;

	/** 获取买家订单评论列表信息 **/
	public static final int JSONDATA_TYPE_BUYER_COMMENT_LIST = 1080;

	/** 评论订单信息 **/
	public static final int JSONDATA_TYPE_COMMENT = 1081;

	/** 获取分享请求参数信息 **/
	public static final int JSONDATA_TYPE_SHARE_PARAMS = 1082;

	/** 获取买家收货地址列表信息 **/
	public static final int JSONDATA_TYPE_USER_ADDRESS_LIST = 1083;

	/** <添加|修改>买家收货地址信息 **/
	public static final int JSONDATA_TYPE_SAVE_ADDRESS = 1084;

	/** 删除买家收货地址信息 **/
	public static final int JSONDATA_TYPE_DELETE_ADDRESS = 1085;

	/** 设为默认收货地址信息 **/
	public static final int JSONDATA_TYPE_SET_DEFAULT_ADDRESS = 1086;

	/** 获取卖家自提地址信息 **/
	public static final int JSONDATA_TYPE_MERCHANT_ADDR = 1087;

	/** 获取百度API坐标信息 **/
	public static final int JSONDATA_TYPE_BAIDU_LOCATION = 1088;

}
