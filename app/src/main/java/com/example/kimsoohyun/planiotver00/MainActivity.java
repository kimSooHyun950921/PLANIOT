package com.example.kimsoohyun.planiotver00;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    menuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        adapter = new menuAdapter();
        listview = (ListView)findViewById(R.id.myplantList);


        if(adapter.isEmpty()){
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("식물이 없어요!");
            ad.setMessage("아직 키우고있는 식물이 없네요 식물을 추가하시겠습니까?");
            ad.setPositiveButton("네",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i) {

                    adapter.addItem(ContextCompat.getDrawable(MainActivity.this,R.drawable.plant2),"초록이","2017년 8월 3일");
                    listview.setAdapter(adapter);
                    dialog.dismiss();
                }
            });
            ad.setNegativeButton("아니요",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            ad.show();
        }
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //ItemMenu item = (ItemMenu)adapterView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
      // adapter.addItem(ContextCompat.getDrawable(this,R.drawable.images),"달심이","2014년 4월 3일");



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.newPost) {
            adapter.addItem(ContextCompat.getDrawable(this,R.drawable.images),"달심이","2014년 4월 3일");

            listview.setAdapter(adapter);
        }
            return super.onOptionsItemSelected(item);
    }






}
