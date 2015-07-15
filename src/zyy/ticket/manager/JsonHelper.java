package zyy.ticket.manager;

import android.content.Context;

public class JsonHelper {

    public SendJsonManager sendJsonManager;

    public TaskManager taskManager;

    public JsonHandlerManager jsonHandlerManager;


    public JsonHelper(Context context) {
        sendJsonManager = new SendJsonManager();
        taskManager = new TaskManager();
        jsonHandlerManager = new JsonHandlerManager(context);
    }
}
