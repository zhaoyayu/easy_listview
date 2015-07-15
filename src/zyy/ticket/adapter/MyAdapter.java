package zyy.ticket.adapter;

/**
 * @author zhaoyayu
 * 
 */
import java.util.List;

import zyy.ticket.holder.ViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;

    protected Context mContext;

    protected List<T> mDatas;

    protected final int mItemLayoutId;


    public MyAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }


    public MyAdapter(Context mContext, int mItemLayoutId) {
        super();
        this.mContext = mContext;
        this.mItemLayoutId = mItemLayoutId;
    }


    /**
     * 设置数据源
     */
    public void setData(List<T> mDatas) {
        this.mDatas = mDatas;
    }


    @Override
    public int getCount() {
        if (mDatas != null && mDatas.size() > 0)
            return mDatas.size();
        return 0;
    }


    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position));
        converts(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }


    /**
     * 获取ViewHolder
     */
    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
    }


    public abstract void convert(ViewHolder viewHolder, T model);


    public void converts(ViewHolder viewHolder, T model, int position) {};
}
