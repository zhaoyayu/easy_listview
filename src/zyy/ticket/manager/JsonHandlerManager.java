package zyy.ticket.manager;

import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.task.DiscoverListTask;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

/**
 * json获取解析加入handler主线程
 */
public class JsonHandlerManager implements Callback {

    // private static JsonHandlerManager instance;
    private Handler handler;


    public JsonHandlerManager(Context context) {
        handler = new Handler(context.getApplicationContext().getMainLooper(), this);
    }


    /**
     * 发送handler 请求
     * 
     * @param msg
     * @param obj
     */
    public void sendHandlerMsg(int msg, Object obj) {
        if (handler != null) {
            Message message = new Message();
            message.what = msg;
            message.obj = obj;
            handler.sendMessage(message);
        }
    }


    /**
     * 销毁handler管理器
     */
    public void destoryHandler() {
        if (handler != null) {
            handler.removeCallbacks(null);
            handler = null;
        }
    }


    @Override
    public boolean handleMessage(Message msg) {
        int message = msg.what;
        switch (message) {
            case JsonHttpConstant.JSONDATA_TYPE_SHOW_LIST:
                DiscoverListTask discoverListTask = (DiscoverListTask) msg.obj;
                if (discoverListTask != null) {
                    discoverListTask.taskCallBack();
                }
                break;
            default:
                break;
        }
        return false;
    }
}
