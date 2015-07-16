package zyy.ticket.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.model.TicketModel;
import zyy.ticket.task.DiscoverListTask;
import zyy.ticket.util.HttpUtils;

import com.alibaba.fastjson.JSON;

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
    public static List<TicketModel> getShowListMode(String cityId, String showTypeId, String venueId, String timeId, int pagesize, int page,
            DiscoverListTask task) {
        List<TicketModel> ticketList = new ArrayList<TicketModel>();
        try {
            String resultUrl = JsonHttpConstant.jsonUrl + JsonHttpConstant.ticketListUrl + "?size=" + pagesize + "&page=" + page + "&city_id=" + cityId
                    + "&project_category_id=" + showTypeId + "&venue_id=" + venueId + "&time_range=" + timeId;
            String resultStr = HttpUtils.getHttpJsonStr(resultUrl);
            if (resultStr == null) {
                return null;
            }
            JSONObject jsonobject = new JSONObject(resultStr);
            task.status = jsonobject.getString(DEALSTATE);
            task.result = jsonobject.getString(DEALCODE);
            task.msg = jsonobject.getString(DEALMSG);
            if (JsonHttpConstant.JSONDATA_RETURN_SUCESS.equals(task.status) && JsonHttpConstant.JSONDATA_SERVER_RETURN_SUCESS.equals(task.result)) {
                JSONObject data_jsonobject = jsonobject.getJSONObject("data");
                String performs_params = data_jsonobject.getString("performs");
                ticketList = JSON.parseArray(performs_params, TicketModel.class);
            } else {
                ticketList = null;
                task.erro = task.msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }




    public static String getValue(JSONObject jsonobject, String key) throws JSONException {
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


    public static Long getLongValue(JSONObject jsonobject, String key) throws JSONException {
        if (jsonobject.has(key)) {
            return (Long) jsonobject.getLong(key);
        }
        return null;
    }


    public static int getIntValue(JSONObject jsonobject, String key) throws JSONException {
        if (jsonobject.has(key)) {
            return (int) jsonobject.getInt(key);
        }
        return -1;
    }


    public static Double getDoubleValue(JSONObject jsonobject, String key) throws JSONException {
        if (jsonobject.has(key)) {
            return (Double) jsonobject.getDouble(key);
        }
        return null;
    }


    public static Boolean getBooleanValue(JSONObject jsonobject, String key) throws JSONException {
        if (jsonobject.has(key)) {
            return (Boolean) jsonobject.getBoolean(key);
        }
        return false;
    }

}
