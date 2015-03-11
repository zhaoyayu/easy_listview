package zyy.ticket.manager;

import zyy.ticket.observer.DiscoverListObserver;
import zyy.ticket.task.DiscoverListTask;

/**
 * 请求json数据
 */
public class SendJsonManager {
	/**
	 * 请求发现演出列表信息
	 * 
	 * @param type
	 * @param cityId
	 * @param showTypeId
	 * @param venueId
	 * @param timeId
	 * @param pageSize
	 * @param currentPage
	 * @param isHandler
	 * @param dlo
	 * @param refreshType
	 */
	public void helpShowListJsonData(int type, String cityId,
			String showTypeId, String venueId, String timeId, int pageSize,
			int currentPage, boolean isHandler, DiscoverListObserver dlo,
			int refreshType) {
		EngineFactory.getInstance().jsonHelper.taskManager
				.addTask(new DiscoverListTask(type, cityId, showTypeId,
						venueId, timeId, pageSize, currentPage, isHandler, dlo,
						refreshType));
	}
}
