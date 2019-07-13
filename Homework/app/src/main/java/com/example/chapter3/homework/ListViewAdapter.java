package com.example.chapter3.homework;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private String[] datas;
    private LayoutInflater layoutInflater;
    private Context context;
    public ListViewAdapter(Context context,String[] datas){
        this.context=context;
        this.datas=datas;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item, null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(datas[position]);
        FrameLayout layoutItem = (FrameLayout) convertView.findViewById(R.id.layout_item);
        if (position % 2 == 1) {
            layoutItem.setBackgroundColor(ContextCompat.getColor(context, R.color.background_light));
        }else{
            layoutItem.setBackgroundColor(ContextCompat.getColor(context, R.color.background_dark));
        }

        return convertView;
    }

}