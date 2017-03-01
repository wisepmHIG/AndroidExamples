package com.example.administrator.spinnerex02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-05.
 */

public class FlagAdapter extends BaseAdapter {
    // 변수선언
    Context context;
    ArrayList<Flag> list;

    // 생성자
    public FlagAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }
    public FlagAdapter(Context context, ArrayList<Flag> list) {
        this.context = context;
        this.list = list;
    }
    // 데이터 추가하는 메서드
    public void addFlag(Flag flag){
        list.add(flag);
    }
    // 4개의 메서드를 오버라이딩한다.
    @Override
    public int getCount() { // 데이터 개수를 리턴한다.
        return list.size();
    }
    @Override
    public Object getItem(int position) { // 데이터를 리턴한다.
        return list.get(position);
    }
    @Override
    public long getItemId(int position) { // 위치를 리턴
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if(convertView==null) {
            layout = new FlagView(context,list.get(position));
        }else{
            layout = (FlagView) convertView;
            ImageView iv = (ImageView)layout.findViewById(R.id.iv);
            iv.setImageResource(list.get(position).getImageID());
            TextView tv = (TextView)layout.findViewById(R.id.tv);
            tv.setText(list.get(position).getFlagName());
        }
        return layout;
    }
}
