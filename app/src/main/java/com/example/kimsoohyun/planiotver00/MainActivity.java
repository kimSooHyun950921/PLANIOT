package com.example.kimsoohyun.planiotver00;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ListView listview;
        menuAdapter adapter = new menuAdapter();
        listview = (ListView)findViewById(R.id.myplantList);
        listview.setAdapter(adapter);
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.images),"달심이","2014년 4월 3일");



    }
}
