package com.example.administrator.gridviewex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-05.
 */

public class HanjaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Hanja> list;
    public HanjaAdapter(Context context, ArrayList<Hanja> list) {
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
        LinearLayout linearLayout = null;
        if(convertView==null){
            linearLayout = new HanjaView(context,list.get(position));
        }else{
            linearLayout = (LinearLayout)convertView;
            ((TextView)linearLayout.findViewById(R.id.tv1)).setText(list.get(position).getHanja());
            ((TextView)linearLayout.findViewById(R.id.tv2)).setText(list.get(position).getHangul());
        }
        return linearLayout;
    }
}
