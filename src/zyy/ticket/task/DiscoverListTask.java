package zyy.ticket.task;

import java.util.List;

import zyy.ticket.manager.EngineFactory;
import zyy.ticket.manager.JsonParser;
import zyy.ticket.model.TicketModel;
import zyy.ticket.observer.DiscoverListObserver;

/**
 * 发现列表task
 */
public class DiscoverListTask extends BaseJsonTask {

    private DiscoverListObserver tlo;

    private List<TicketModel> model;

    int ticketType;

    int pageSize;

    String cityId;

    String showTypeId;

    String venueId;

    String timeId;

    int currentPage;

    int refreshType;


    public DiscoverListTask(int type, String cityId, String showTypeId, String venueId, String timeId, int pageSize, int currentPage, boolean isHandler,
            DiscoverListObserver tlo, int refreshType) {
        this.type = type;
        this.tlo = tlo;
        this.cityId = cityId;
        this.showTypeId = showTypeId;
        this.venueId = venueId;
        this.timeId = timeId;
        this.isHandler = isHandler;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.refreshType = refreshType;
    }


    /**
     * 获取观察者对象
     * 
     * @return
     */
    public DiscoverListObserver getObserver() {
        return tlo;
    }


    /**
     * 任务完成回调
     */
    public void taskCallBack() {
        tlo.getJsonData(type, refreshType, model, erro);
    }


    @Override
    public void run() {
        model = JsonParser.getShowListMode(cityId, showTypeId, venueId, timeId, pageSize, currentPage, DiscoverListTask.this);
        if (isHandler) {
            EngineFactory.getInstance().jsonHelper.jsonHandlerManager.sendHandlerMsg(type, DiscoverListTask.this);
        } else {
            taskCallBack();
        }
    }

}
