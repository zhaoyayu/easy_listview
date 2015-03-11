package zyy.ticket.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.model.TicketModel;
import zyy.ticket.task.DiscoverListTask;
import zyy.ticket.util.HttpUtils;
import android.util.Log;

/**
 * 解析json数据
 */
public class JsonParser {

	public final static String DEALSTATE = "status";
	public final static String DEALCODE = "code";
	public final static String DEALMSG = "msg";

	/**
	 * 返回发现演出列表数据
	 * 
	 * @param cityId
	 * @param showTypeId
	 * @param venueId
	 * @param timeId
	 * @param pagesize
	 * @param page
	 * @param task
	 * @return
	 */
	public static List<TicketModel> getShowListMode(String cityId,
			String showTypeId, String venueId, String timeId, int pagesize,
			int page, DiscoverListTask task) {
		List<TicketModel> ticketList = new ArrayList<TicketModel>();
		try {
			String resultUrl = JsonHttpConstant.jsonUrl
					+ JsonHttpConstant.ticketListUrl + "?size=" + pagesize
					+ "&page=" + page + "&city_id=" + cityId
					+ "&project_category_id=" + showTypeId + "&venue_id="
					+ venueId + "&time_range=" + timeId;
			Log.i("gefy", "发现演出resultUrl===" + resultUrl);
			String resultStr = HttpUtils.getHttpJsonStr(resultUrl);
			Log.i("gefy", "发现演出resultStr===" + resultStr);
			if (resultStr == null)
				return null;

			JSONObject jsonobject = new JSONObject(resultStr);
			task.status = jsonobject.getString(DEALSTATE);
			task.result = jsonobject.getString(DEALCODE);
			task.msg = jsonobject.getString(DEALMSG);
			if (JsonHttpConstant.JSONDATA_RETURN_SUCESS.equals(task.status)
					&& JsonHttpConstant.JSONDATA_SERVER_RETURN_SUCESS
							.equals(task.result)) {
				JSONObject data_jsonobject = jsonobject.getJSONObject("data");
				String performs_params = data_jsonobject.getString("performs");
				JSONArray performs_paramsArray = new JSONArray(
						performs_params.trim());
				for (int i = 0; i < performs_paramsArray.length(); i++) {
					JSONObject paramsObject = performs_paramsArray
							.getJSONObject(i);
					String perform_id = getValue(paramsObject, "perform_id");
					String project_name = getValue(paramsObject, "project_name");
					String venue_name = getValue(paramsObject, "venue_name");
					String venue_longitude = getValue(paramsObject,
							"venue_longitude");
					String venue_latitude = getValue(paramsObject,
							"venue_latitude");
					String project_image = getValue(paramsObject,
							"project_image");
					String vertical_image = getValue(paramsObject,
							"vertical_image");
					String horizontal_image = getValue(paramsObject,
							"horizontal_image");
					String start_time = getValue(paramsObject, "start_time");
					String low_price_original = getValue(paramsObject,
							"low_price_original");
					String high_price_original = getValue(paramsObject,
							"high_price_original");
					String free_count = getValue(paramsObject, "free_count");
					String low_price_transaction = getValue(paramsObject,
							"low_price_transaction");
					String high_price_transaction = getValue(paramsObject,
							"high_price_transaction");

					TicketModel ticketModel = new TicketModel();
					ticketModel.setId(perform_id);
					ticketModel.setTicketname(project_name);
					ticketModel.setVenuename(venue_name);
					ticketModel.setTicketthumb(project_image);
					ticketModel.setStarttime(start_time);
					ticketModel.setLow_price_original(low_price_original);
					ticketModel.setHigh_price_original(high_price_original);
					ticketModel.setLow_price(low_price_transaction);
					ticketModel.setHighest_price(high_price_transaction);
					ticketModel.setFreecount(free_count);
					ticketModel.setVertical_image(vertical_image);
					ticketModel.setHorizontal_image(horizontal_image);
					ticketList.add(ticketModel);
				}
			} else {
				ticketList = null;
				task.erro = task.msg;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	public static String getDateToDay(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (time != null && !"".equals(time.trim())) {
			Long l = new Long(time);
			return sdf.format(new Date(l.longValue()));
		} else {
			return "";
		}
	}

	public static String getDateToSecond(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (time != null && !"".equals(time.trim())) {
			Long l = new Long(time);
			return sdf.format(new Date(l.longValue()));
		} else {
			return "";
		}
	}

	public static String getValue(JSONObject jsonobject, String key)
			throws JSONException {
		if (jsonobject.has(key)) {
			String value = (String) jsonobject.getString(key);
			if ("null".equals(value)) {
				return null;
			} else {
				return value;
			}
		}
		return "";
	}

	public static Long getLongValue(JSONObject jsonobject, String key)
			throws JSONException {
		if (jsonobject.has(key)) {
			return (Long) jsonobject.getLong(key);
		}
		return null;
	}

	public static int getIntValue(JSONObject jsonobject, String key)
			throws JSONException {
		if (jsonobject.has(key)) {
			return (int) jsonobject.getInt(key);
		}
		return -1;
	}

	public static Double getDoubleValue(JSONObject jsonobject, String key)
			throws JSONException {
		if (jsonobject.has(key)) {
			return (Double) jsonobject.getDouble(key);
		}
		return null;
	}

	public static Boolean getBooleanValue(JSONObject jsonobject, String key)
			throws JSONException {
		if (jsonobject.has(key)) {
			return (Boolean) jsonobject.getBoolean(key);
		}
		return false;
	}

}
