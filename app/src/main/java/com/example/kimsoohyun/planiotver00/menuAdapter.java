package com.example.kimsoohyun.planiotver00;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kimsoohyun on 2017-08-01.
 */
public class menuAdapter extends BaseAdapter{
    private ArrayList<MenuItem> menuList = new ArrayList<>();
    public menuAdapter(){

    }


    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_item_layout, parent, false);}
            ImageView iconImageView = (ImageView) view.findViewById(R.id.myPlantImage);
            TextView plantName = (TextView) view.findViewById(R.id.myPlantName);
            TextView plantDate = (TextView) view.findViewById(R.id.plantDate);


            iconImageView.setImageDrawable(menuList.get(position).getMyPlantImage());
            plantName.setText(menuList.get(position).getName());
            plantDate.setText(menuList.get(position).getDate());
            return view;



    }
    public void addItem(Drawable icon,String name,String date) {
        MenuItem item = new MenuItem(icon,name,date);
        menuList.add(item);
    }

}
