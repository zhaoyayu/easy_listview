package zyy.ticket.task;

/**
 * 任务模型基类
 */
public abstract class BaseJsonTask implements Runnable {
	/** 任务类型 **/
	public int type;
	/** 任务结果和错误信息 **/
	public String result, erro, msg, status;
	/** 是否加入handler队列 **/
	public boolean isHandler;

	public int getType() {
		return type;
	}

}
