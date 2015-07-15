package zyy.ticket.activity;

import java.util.ArrayList;
import java.util.List;

import zhaoyayu.ticket.R;
import zyy.ticket.application.MyApplication;
import zyy.ticket.constant.JsonHttpConstant;
import zyy.ticket.model.TicketModel;
import zyy.ticket.observer.DiscoverListObserver;
import zyy.ticket.util.UiUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private long mExitTime;

    private ListView showListView;

    public static List<TicketModel> showList = new ArrayList<TicketModel>();

    String showTypeId = "0";

    int venueId = 0;

    int timeId = 1;

    private int showListPage = 1;

    private ShowListAdapter showListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }


    private void initView() {
        showListView = (ListView) findViewById(R.id.discover_item_list);
        showListAdapter = new ShowListAdapter();
        showListAdapter.setData(showList);
        showListView.setAdapter(showListAdapter);
    }


    private void initData() {
        requestShowList(showTypeId);
    }


    /**
     * 刷新发现列表数据
     */
    private void flushShowList() {
        showListAdapter.setData(showList);
        showListAdapter.notifyDataSetChanged();
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
                    UiUtils.showToast(MainActivity.this, "获取失败");
                }
            }
        };
        jsonHelper.sendJsonManager.helpShowListJsonData(JsonHttpConstant.JSONDATA_TYPE_SHOW_LIST, "852", showTypeId, venueId + "", timeId + "", 100,
                showListPage, true, discoverListObserver, 0);
    }

    /**
     * 项目列表adapter
     */
    class ShowListAdapter extends BaseAdapter {

        List<TicketModel> mShowList;

        private ShowViewHolder showViewHolder;


        public void setData(List<TicketModel> showList) {
            this.mShowList = showList;
        }


        @Override
        public int getCount() {
            if (mShowList != null)
                return mShowList.size();
            return 0;
        }


        @Override
        public Object getItem(int position) {
            return mShowList.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final TicketModel ticketModel = mShowList.get(position);
            if (convertView == null) {
                showViewHolder = new ShowViewHolder();
                convertView = inflater.inflate(R.layout.discover_item, null);
                showViewHolder.tv_item_price = (TextView) convertView.findViewById(R.id.tv_item_price);
                showViewHolder.tv_item_title = (TextView) convertView.findViewById(R.id.tv_item_title);
                showViewHolder.tv_item_num = (TextView) convertView.findViewById(R.id.tv_item_num);
                showViewHolder.iv_item_poster = (ImageView) convertView.findViewById(R.id.iv_item_poster);
                convertView.setTag(showViewHolder);
            } else {
                showViewHolder = (ShowViewHolder) convertView.getTag();
            }
            showViewHolder.tv_item_title.setText(ticketModel.getTicketname());
            showViewHolder.tv_item_price.setText(ticketModel.getLow_price() + " - " + ticketModel.getHighest_price());
            showViewHolder.tv_item_num.setText("" + ticketModel.getFreecount() + "张");
            showViewHolder.iv_item_poster.setImageResource(R.drawable.discover_default);
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent(context, EasyActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
    }

    /**
     * 发现列表缓存控件
     */
    class ShowViewHolder {

        // 图片
        ImageView iv_item_poster;

        // 标题
        TextView tv_item_title;

        // 价格
        TextView tv_item_price;

        // 张数
        TextView tv_item_num;
    }


    /**
     * 连续按两次返回键退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 800) {
                UiUtils.showToast(this, "再按一次退出");
                mExitTime = System.currentTimeMillis();
            } else {
                mExitTime = 0;
                MyApplication.getInstance().exit();
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
