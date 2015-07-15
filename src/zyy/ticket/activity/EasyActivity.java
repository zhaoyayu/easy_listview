package zyy.ticket.activity;

import java.util.ArrayList;
import java.util.List;

import zhaoyayu.ticket.R;
import zyy.ticket.adapter.MyAdapter;
import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.holder.ViewHolder;
import zyy.ticket.model.TicketModel;
import zyy.ticket.observer.DiscoverListObserver;
import zyy.ticket.util.UiUtils;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class EasyActivity extends BaseActivity {

    private ListView showListView;

    public static List<TicketModel> showList = new ArrayList<TicketModel>();

    String showTypeId = "0";

    int venueId = 0;

    int timeId = 1;

    private int showListPage = 1;

    private MyAdapter<TicketModel> myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }


    private void initData() {
        requestShowList(showTypeId);
    }


    private void initView() {
        showListView = (ListView) findViewById(R.id.discover_item_list);
        myAdapter = new MyAdapter<TicketModel>(context, showList, R.layout.discover_item) {

            @Override
            public void convert(ViewHolder viewHolder, final TicketModel model) {
                viewHolder.setText(R.id.tv_item_title, model.getTicketname());
                viewHolder.setText(R.id.tv_item_price, model.getLow_price() + " - " + model.getHighest_price());
                viewHolder.setText(R.id.tv_item_num, model.getFreecount() + "张");
                viewHolder.setImageByUrl(R.id.iv_item_poster, model.getHorizontal_image(), R.drawable.discover_default);
                viewHolder.getConvertView().setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        UiUtils.showToast(context, model.getTicketname() + "onclick");
                    }
                });
            }
        };
        showListView.setAdapter(myAdapter);
    }


    /**
     * 刷新发现列表数据
     */
    private void flushShowList() {
        myAdapter.setData(showList);
        myAdapter.notifyDataSetChanged();
    }


    /**
     * 请求发现演出列表数据
     */
    private void requestShowList(String showTypeId) {
        DiscoverListObserver discoverListObserver = new DiscoverListObserver() {

            @Override
            public void getJsonData(int type, int refreshType, List<TicketModel> data, String erro) {
                if (data != null) {
                    if (data.size() > 0) {
                        showList.addAll(data);
                        flushShowList();
                    }
                } else {
                    UiUtils.showToast(EasyActivity.this, "获取失败");
                }
            }
        };
        jsonHelper.sendJsonManager.helpShowListJsonData(JsonHttpConstant.JSONDATA_TYPE_SHOW_LIST, "852", showTypeId, venueId + "", timeId + "", 100,
                showListPage, true, discoverListObserver, 0);
    }

}
