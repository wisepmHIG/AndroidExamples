package com.example.administrator.newsapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-19.
 */

public class NewsAdapter extends BaseAdapter{
    Context context;
    ArrayList<NewsItem> list;
    public NewsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }
    public NewsAdapter(Context context, ArrayList<NewsItem> list) {
        this.context = context;
        this.list = list;
    }
    public void addNewsItem(NewsItem item){
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
        NewsItemView view;
        if(convertView==null) {
            view = new NewsItemView(context, list.get(position));
        }else{
            view = (NewsItemView)convertView;
            view.setTitleTV(list.get(position).getTitle());
            view.setDescTV(list.get(position).getDescription());
        }
        return view;
    }
}
