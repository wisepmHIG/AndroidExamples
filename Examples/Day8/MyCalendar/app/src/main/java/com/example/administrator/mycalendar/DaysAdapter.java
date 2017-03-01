package com.example.administrator.mycalendar;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016-12-02.
 */

public class DaysAdapter extends BaseAdapter {
    Context context;
    List<Days> list;

    public DaysAdapter(Context context,List<Days> list) {
        this.context = context;
        this.list = list;
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
          return new DaysView(context,list.get(position));
    }
}
