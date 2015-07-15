package zyy.ticket.manager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import zyy.ticket.task.BaseJsonTask;

/**
 * 任务管理器类,通过线程池，管理json
 */
public class TaskManager {

    private int maxThreadCount = 7;

    private BlockingQueue<Runnable> downloadQueue = new LinkedBlockingQueue<Runnable>();

    private ExecutorService executorService;


    public TaskManager() {
        executorService = new ThreadPoolExecutor(this.maxThreadCount, maxThreadCount + 1, 1, TimeUnit.SECONDS, downloadQueue);
    }


    /**
     * 开启json请求任务
     * 
     * @param type
     * @param jho
     */
    public void addTask(BaseJsonTask bt) {
        executorService.submit(bt);
    }


    /**
     * 销毁
     */
    public void destory() {
        executorService.shutdown();
    }

}
