package com.example.administrator.daumwebtoonex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-12.
 */

public class ItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<Item> list = new ArrayList<>();

    public ItemAdapter(Context context) {
        this.context = context;
    }
    public ItemAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }
    public void addItem(Item item){
        list.add(item);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView view;
        if(convertView==null){
            view = new ItemView(context,list.get(position));
        }else{
            view = (ItemView)convertView;
            view.setImageView(list.get(position).getUrl());
        }
        return view;
    }
}
