package zyy.ticket.util;

import zyy.ticket.application.MyApplication;
import android.content.Context;
import android.widget.Toast;

public class UiUtils {

    /**
     * 获取Context
     */
    public static Context getContext() {
        return MyApplication.getInstance().getApplicationContext();
    }


    /**
     * 展示toast
     */
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }



    /**
     * 判断是都为空串或"null"串
     */
    public static boolean isEmptyStr(String s) {
        if (s != null && !"".equals(s) && !"null".equals(s)) {
            return false;
        }
        return true;
    }
}
