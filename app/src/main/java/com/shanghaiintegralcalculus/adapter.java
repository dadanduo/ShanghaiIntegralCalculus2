package com.shanghaiintegralcalculus;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenda on 2017/8/14.
 */

public class adapter extends BaseAdapter {

    private  LayoutInflater mInflater;
    Context   ct;
    public adapter(Context ct)
    {
        this.mInflater = LayoutInflater.from(ct);
        this.ct=ct;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        //显示优化（只要之前显示过的就可以不再再次从布局文件读取，直接从缓存中读取--ViewHolder的作用）
        //其实是setTag和getTag中标签的作用
        ViewHolder holder =  null ;
        if(convertView==null){ //如果是第一次显示该页面（要记得保存到viewholder中供下次直接从缓存中调用）
            holder =  new  ViewHolder();
            //获取list_item布局文件的视图
            convertView = mInflater.inflate(R.layout.mainlistview, null);
            //设置控件集到convertView
            convertView.setTag(holder);
        }
        else  { //如果之前已经显示过该页面，则用viewholder中的缓存直接刷屏
            holder =(ViewHolder)convertView.getTag();
        }

        return convertView;
    }
    public final class  ViewHolder
    {

    }

}
