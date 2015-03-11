package zyy.ticket.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import zyy.ticket.application.MyApplication;
import android.os.Build;
import android.util.Log;

/**
 * http请求工具类
 * 
 * @author gefangyan
 * 
 */
public class HttpUtils {
	private static int TIME_OUT = 15000;
	private static int SUC = 200;
	private static int NOT_MODIFIED = 304;

	/***
	 * ◆200 (OK): 找到了该资源，并且一切正常。 ◆304 (NOT MODIFIED):
	 * 该资源在上次请求之后没有任何修改。这通常用于浏览器的缓存机制。 ◆401 (UNAUTHORIZED):
	 * 客户端无权访问该资源。这通常会使得浏览器要求用户输入用户名和密码，以登录到服务器。 ◆403 (FORBIDDEN):
	 * 客户端未能获得授权。这通常是在401之后输入了不正确的用户名或密码。 ◆404 (NOT FOUND): 在指定的位置不存在所申请的资源。
	 */

	/**
	 * get请求获取json字符串数据
	 * 
	 * @param getUrl
	 * @return
	 */
	public static String getHttpJsonStr(String getUrl) {
		String jsonStr = null;
		// 设置超时
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
		HttpConnectionParams.setSoTimeout(params, TIME_OUT);

		HttpClient httpClient = new DefaultHttpClient(params);
		HttpGet httpGet = new HttpGet(getUrl);

		httpGet.addHeader("User-Agent", setUA_header());
		try {
			HttpResponse response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			if ((statusLine != null && statusLine.getStatusCode() == SUC)
					|| (statusLine != null && statusLine.getStatusCode() == NOT_MODIFIED)) {
				HttpEntity entity = response.getEntity();
				jsonStr = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}

	public static byte[] getStreamBytes(InputStream is) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		byte[] result = baos.toByteArray();
		is.close();
		baos.close();
		return result;
	}

	/**
	 * 发送POST请求
	 * 
	 * @param postUrl
	 * @param postJson
	 * @return
	 */
	public static String postJsonHttpJsonStr(String postUrl, String postJson) {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
		HttpConnectionParams.setSoTimeout(params, TIME_OUT);
		DefaultHttpClient client = new DefaultHttpClient(params);
		// 创建一个请求
		HttpPost post = new HttpPost(postUrl);
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
		post.addHeader("User-Agent", setUA_header());
		try {
			post.setEntity(new StringEntity(postJson));
			HttpResponse response = client.execute(post);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine != null
					&& response.getStatusLine().getStatusCode() == 200) {
				InputStream is = response.getEntity().getContent();
				byte[] data = getStreamBytes(is);
				return new String(data);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 发送POST请求
	 * 
	 * @param postUrl
	 * @return
	 */
	public static String postHttpJsonStr(String postUrl,
			List<BasicNameValuePair> values) {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
		HttpConnectionParams.setSoTimeout(params, TIME_OUT);
		DefaultHttpClient client = new DefaultHttpClient(params);
		// 创建一个请求
		HttpPost post = new HttpPost(postUrl);
		post.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		post.addHeader("User-Agent", setUA_header());
		try {
			post.setEntity(new UrlEncodedFormEntity(values, HTTP.UTF_8));
			HttpResponse response = client.execute(post);
			StatusLine statusLine = response.getStatusLine();
			if ((statusLine != null && response.getStatusLine().getStatusCode() == 200)
					|| (statusLine != null && statusLine.getStatusCode() == NOT_MODIFIED)) {
				InputStream is = response.getEntity().getContent();
				byte[] data = getStreamBytes(is);
				String returnData = new String(data);
				return returnData;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * put请求
	 * 
	 * @param putUrl
	 * @param values
	 * @return
	 */
	public static String putHttpJsonStr(String putUrl,
			List<BasicNameValuePair> values) {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
		HttpConnectionParams.setSoTimeout(params, TIME_OUT);
		DefaultHttpClient client = new DefaultHttpClient(params);
		// 创建一个请求
		HttpPut put = new HttpPut(putUrl);
		put.addHeader("Content-Type", "application/x-www-form-urlencoded");
		put.addHeader("User-Agent", setUA_header());
		try {
			put.setEntity(new UrlEncodedFormEntity(values, HTTP.UTF_8));
			HttpResponse response = client.execute(put);
			StatusLine statusLine = response.getStatusLine();
			if ((statusLine != null && response.getStatusLine().getStatusCode() == 200)
					|| (statusLine != null && statusLine.getStatusCode() == NOT_MODIFIED)) {
				InputStream is = response.getEntity().getContent();
				byte[] data = getStreamBytes(is);
				String returnData = new String(data, "UTF-8");
				return returnData;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 发送带流的post请求
	 * 
	 * @param postUrl
	 * @param values
	 * @param user_image
	 * @return
	 */
	public static String postHttpStream(String postUrl,
			List<BasicNameValuePair> values, byte[] user_image) {
		String BOUNDARY = "---------------------------7db1c523809b2";// 数据分割线
		// File file = new File(fileName); // 要上传的文件
		// 构造param参数部分的数据内容，格式都是相同的，依次添加param1和param2
		StringBuilder sb = new StringBuilder();
		if (values != null) {
			// 拼接参数
			for (int i = 0; i < values.size(); i++) {
				BasicNameValuePair valuePair = values.get(i);
				String name = valuePair.getName();
				String value = valuePair.getValue();
				sb.append("--" + BOUNDARY + "\r\n");
				sb.append("Content-Disposition: form-data; name=" + name
						+ "\r\n");
				sb.append("\r\n");
				sb.append(value + "\r\n");
			}
		}
		if (user_image != null) {
			// 构造要上传文件的前段参数内容，和普通参数一样，在这些设置后就可以紧跟文件内容了。
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data; name=\"user_image\"; filename=\""
					+ user_image + "\"" + "\r\n");
			sb.append("Content-Type: text/plain" + "\r\n");
			sb.append("\r\n");
		}
		try {
			byte[] before = sb.toString().getBytes("UTF-8");
			byte[] after = ("--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
			URL url = new URL(postUrl);
			// 得到HttpURLConnection对象，设置一些头信息基本属性
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);
			conn.setRequestProperty("HOST", url.getHost());
			conn.setRequestProperty("User-Agent", setUA_header());
			conn.setDoOutput(true);
			OutputStream out = conn.getOutputStream();
			// 写入参数信息
			out.write(before);
			// 写入文件数据
			if (user_image != null) {
				out.write(user_image, 0, user_image.length);
			}
			// 写结束符，代表该HTTP组包完毕
			out.write(after);
			// 发送出去
			out.flush();
			out.close();
			Log.i("zyy", "postHttpStream 返回码为: " + conn.getResponseCode());
			Log.i("zyy", "postHttpStream 返回信息为: " + conn.getResponseMessage());
			InputStream is = conn.getInputStream();
			byte[] data = getStreamBytes(is);
			String returnData = new String(data);
			return returnData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String setUA_header() {
		JSONObject params = new JSONObject();
		String token = MyApplication.getInstance().token;
		try {
			params.put("mac", MyApplication.MACADRESS);
			params.put("platform_id", "200");
			params.put("screen", MyApplication.WIDTH + "*"
					+ MyApplication.HEIGHT);
			params.put("client_version", MyApplication.VERSIONNAME);
			params.put("user_id", "100");
			params.put("token", token);// 认证token
			params.put("device_token",
					"AksZJeVKaN00NFuuaozdZoZTYRLkf1SUJz5Os-GX5IuO");
			params.put("device_name", Build.MODEL);
			params.put("device_version", Build.VERSION.SDK);
			params.put("channel_id", "100");
			params.put("city_id", "852");
			Log.i("zyy", "setUA_header====" + params.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
		return params.toString();
	}
}
