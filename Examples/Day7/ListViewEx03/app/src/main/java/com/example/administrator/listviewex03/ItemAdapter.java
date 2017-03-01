package com.example.administrator.listviewex03;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-04.
 */

public class ItemAdapter extends BaseAdapter {
    // 컨텍스트변수와 리스트에 뿌려주ㅜㄹ 데이터를 저장하는 변수를 만든다.
    Context context;
    ArrayList<Item> list;

    // 생성자를 작성
    public ItemAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }
    public ItemAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    // 데이터를 추가하는 메서드
    public void addItem(Item item){
        list.add(item);
    }

    @Override
    public int getCount() {
        // 데이터의 개수를 리턴한다.
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // 지정한 데이터를 리턴하게 만든다.
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // 지정한 아이템의 번호(index)를 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 리스트에 보일 뷰를 만들어서 리턴하게 한다.
        ItemView itemView = null;
        Item item = list.get(position);

        if(convertView!=null){
            itemView = (ItemView)convertView;
            itemView.setImageView(item.getImageID());
            itemView.setTextView1(item.getTitle());
            itemView.setTextView2(item.getContent());
        }else{
            itemView = new ItemView(context,item);
        }

        return itemView;
    }
}
