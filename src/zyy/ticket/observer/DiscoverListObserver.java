package zyy.ticket.observer;

import java.util.List;

import zyy.ticket.model.TicketModel;

public abstract class DiscoverListObserver extends AbstractObserver {

    // 获得json数据解析后返回
    public abstract void getJsonData(int type, int refreshType, List<TicketModel> data, String erro);

}
