package zyy.ticket.util;

import java.util.regex.Pattern;

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
	 * 判断手机号码
	 */
	public static boolean isPhoneNum(String input) {
		String regex = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		boolean result = p.matches(regex, input);
		return result;
	}

	/** dip转换px */
	public static int dip2px(int dip) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/** pxz转换dip */
	public static int px2dip(int px) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/**
	 * 判断是都为空串或"null"串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmptyStr(String s) {
		if (s != null && !"".equals(s) && !"null".equals(s)) {
			return false;
		}
		return true;
	}
}
