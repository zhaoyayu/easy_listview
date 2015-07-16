package zyy.ticket.activity;

import java.util.ArrayList;
import java.util.List;

import zhaoyayu.ticket.R;
import zyy.ticket.adapter.MyAdapter;
import zyy.ticket.constant.Constant;
import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.holder.ViewHolder;
import zyy.ticket.model.TicketModel;
import zyy.ticket.observer.DiscoverListObserver;
import zyy.ticket.util.UiUtils;
import zyy.ticket.view.RefreshLayout;
import zyy.ticket.view.RefreshLayout.OnLoadListener;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MainActivity extends BaseActivity implements OnRefreshListener, OnLoadListener {

    private ListView showListView;

    public static List<TicketModel> showList = new ArrayList<TicketModel>();

    String showTypeId = "0";

    int venueId = 0;

    int timeId = 1;

    private int showListPage = 1;

    private MyAdapter<TicketModel> myAdapter;

    private RefreshLayout sw_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }


    private void initData() {
        requestShowList(showTypeId, Constant.REFRESH_TYPE_PULL);
    }


    private void initView() {
        sw_list = (RefreshLayout) findViewById(R.id.sw_list);
        sw_list.setOnRefreshListener(this);
        sw_list.setOnLoadListener(this);
        sw_list.setColorSchemeResources(Constant.PULL_COLORS);
        showListView = (ListView) findViewById(R.id.discover_item_list);
        myAdapter = new MyAdapter<TicketModel>(context, showList, R.layout.discover_item) {

            @Override
            public void convert(ViewHolder viewHolder, final TicketModel model) {
                viewHolder.setText(R.id.tv_item_title, model.getProject_name());
                viewHolder.setText(R.id.tv_item_price, model.getLow_price_transaction() + " - " + model.getHigh_price_transaction());
                viewHolder.setText(R.id.tv_item_num, model.getFree_count() + "张");
                viewHolder.setImageByUrl(R.id.iv_item_poster, model.getHorizontal_image(), R.drawable.discover_default);
                viewHolder.getConvertView().setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        UiUtils.showToast(context, model.getProject_name() + "onclick");
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
    private void requestShowList(String showTypeId, final int rType) {
        if (rType == Constant.REFRESH_TYPE_MORE) {
            if (showList.size() <= 0) {
                sw_list.setLoading(false);
            } else if (showList.size() % Constant.listLoadNum != 0) {
                UiUtils.showToast(this, "没有更多数据");
                sw_list.setLoading(false);
                return;
            }
        }
        if (rType == Constant.REFRESH_TYPE_MORE) {
            showListPage++;
        } else if (rType == Constant.REFRESH_TYPE_PULL) {
            showListPage = 1;
        }
        DiscoverListObserver discoverListObserver = new DiscoverListObserver() {

            @Override
            public void getJsonData(int type, int refreshType, List<TicketModel> data, String erro) {
                if (data != null) {
                    if (rType == Constant.REFRESH_TYPE_MORE) {
                        showList.addAll(data);
                    } else if (rType == Constant.REFRESH_TYPE_PULL) {
                        showList = data;
                    }
                    flushShowList();
                } else {
                    UiUtils.showToast(MainActivity.this, "获取失败");
                }
                sw_list.setLoading(false);
                sw_list.setRefreshing(false);
            }
        };
        jsonHelper.sendJsonManager.helpShowListJsonData(JsonHttpConstant.JSONDATA_TYPE_SHOW_LIST, "852", showTypeId, venueId + "", timeId + "",
                Constant.listLoadNum, showListPage, true, discoverListObserver, 0);
    }


    @Override
    public void onLoad() {
        requestShowList(showTypeId, Constant.REFRESH_TYPE_MORE);
    }


    @Override
    public void onRefresh() {
        requestShowList(showTypeId, Constant.REFRESH_TYPE_PULL);
    }

}
