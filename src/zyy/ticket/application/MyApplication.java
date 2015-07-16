package zyy.ticket.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * application类
 * 
 */
public class MyApplication extends Application {

    private static MyApplication instance = null;

    /** mac地址 **/
    public static String MACADRESS = "";

    /** 客户端版本号 **/
    public static String VERSIONCODE = "";

    public static String VERSIONNAME = "1.1.0";

    /** 标示用户是否登录 **/
    public static String token = "";

    public List<Activity> activityList = new ArrayList<Activity>(); // activity集合


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }


    public static MyApplication getInstance() {
        return instance;
    }


    // 添加Activity 到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
        Log.i("BaseActivity", "create==" + activity.getClass().getSimpleName());
    }


    // 从容器中移除Activity
    public void removeActivity(Activity activity) {
        activityList.remove(activity);
        Log.i("BaseActivity", "destroy==" + activity.getClass().getSimpleName());
    }


    /**
     * 循环退出activity
     */
    public void exit() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
                Log.i("BaseActivity", "exit==" + activity.getClass().getSimpleName());
            }
        }
        System.exit(0);
    }

}
