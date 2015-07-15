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

    public static String jsonUrl = "http://api.bapp.piao.cn";

    /** 请求演出列表地址 **/
    public static String ticketListUrl = "/ticket/discovery";

    /** 演出票列表信息 **/
    public static final int JSONDATA_TYPE_SHOW_LIST = 1001;


}
