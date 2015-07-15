package zyy.ticket.holder;

import zhaoyayu.ticket.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * @author zhaoyayu
 * 
 */
public class ViewHolder {

    private final SparseArray<View> mViews;

    private View mConvertView;

    private DisplayImageOptions options;


    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        initImageLoader();
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }


    /**
     * 获取一个ViewHolder对象,单例
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }


    /**
     * 通过控件的Id获取对于的控件，如果没有则将改id填入容器,避免多次findViewById
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * 获取ConvertView
     */
    public View getConvertView() {
        return mConvertView;
    }


    /**
     * 为TextView设置字符串
     * 
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }


    public ViewHolder setTexts(int viewId, String text) {
        TextView view = (TextView) mConvertView.findViewById(viewId);
        view.setText(text);
        return this;
    }


    /**
     * 为ImageView设置资源图片
     * 
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }


    /**
     * 为ImageView设置图片
     * 
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


    /**
     * 设置Textview文字颜色
     * 
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }


    /**
     * 设置view是否可见
     * 
     * @param viewId
     * @param v
     * @return
     */
    public ViewHolder setVisibility(int viewId, int v) {
        getView(viewId).setVisibility(v);
        return this;
    }


    /**
     * 为ImageView设置网络图片
     * 
     * @param viewId
     * @param url
     * @param drawableId
     * @return
     */
    public ViewHolder setImageByUrl(int viewId, String url, int drawableId) {
        initImageLoader();
        // ImageLoader.getInstance().displayImage(url, (ImageView) getView(viewId), options);
        return this;
    }



    private void initImageLoader(int drawableId) {
        if (options == null) {
            options = new DisplayImageOptions.Builder() // 设置图片下载期间显示的图片
                    .showImageForEmptyUri(drawableId) // 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(drawableId) // 设置图片加载或解码过程中发生错误显示的图片
                    .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                    .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                    .build();
        }
    }


    private void initImageLoader() {
        if (options == null) {
            options = new DisplayImageOptions.Builder() // 设置图片下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.discover_default) // 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.discover_default) // 设置图片加载或解码过程中发生错误显示的图片
                    .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                    .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                    .build();
        }
    }

}
