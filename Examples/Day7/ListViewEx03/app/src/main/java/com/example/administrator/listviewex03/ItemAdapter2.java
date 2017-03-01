package com.example.administrator.listviewex03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-02-04.
 */

public class ItemAdapter2 extends ArrayAdapter<Item> {
    Context context;
    int resource;
    List<Item> list;
    public ItemAdapter2(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = null;
        if(convertView!=null){
            linearLayout = (LinearLayout)convertView;
        }else{
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linearLayout = (LinearLayout) inflater.inflate(resource,null);
        }
        ImageView imageView = (ImageView)linearLayout.findViewById(R.id.iv);
        TextView  textView1 = (TextView)linearLayout.findViewById(R.id.tv1);
        TextView  textView2 = (TextView)linearLayout.findViewById(R.id.tv2);
        Item item = list.get(position);
        imageView.setImageResource(item.getImageID());
        textView1.setText(item.getTitle());
        textView2.setText(item.getContent());
        return linearLayout;
    }
}
