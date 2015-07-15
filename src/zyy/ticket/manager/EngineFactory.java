package zyy.ticket.manager;

import android.content.Context;

/**
 * 引擎工厂 引擎入口
 * 
 */
public class EngineFactory {

    private static EngineFactory engine;

    public JsonHelper jsonHelper;

    private static Context context;


    public EngineFactory() {
        jsonHelper = new JsonHelper(context);
    }


    /**
     * 单例模式
     * 
     * @return
     */
    public static EngineFactory getInstance() {
        if (engine == null) {
            synchronized (EngineFactory.class) {
                if (engine == null) {
                    engine = new EngineFactory();
                }
            }
        }
        return engine;
    }


    /**
     * 初始化context
     * 
     * @param context
     */
    public static Context initContext(Context con) {
        context = con;
        return context;
    }
}
