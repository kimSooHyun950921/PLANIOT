package com.example.kimsoohyun.planiotver00;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;



public class MainActivity extends AppCompatActivity {
    ListView listview;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MAINACTIVITY";
   // registerBroadcastReceiver();
   //getInstanceIdToken()
    menuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent intent =getIntent();
        String plantName;
        adapter = new menuAdapter();
        listview = (ListView) findViewById(R.id.myplantList);
        int plantImage;


        if(intent.hasExtra("PLANTNAME")==true) {
            plantName = intent.getExtras().getString("PLANTNAME");
            plantImage = intent.getExtras().getInt("PLANTIMAGE");
            /*db에 저장한것을 adapter에 넣어주기*/
            adapter.addItem(ContextCompat.getDrawable(MainActivity.this, plantImage), plantName, "2017년 8월 3일");
            listview.setAdapter(adapter);
        }

        if(adapter.isEmpty()){
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("식물이 없어요!");
            ad.setMessage("아직 키우고있는 식물이 없네요 식물을 추가하시겠습니까?");
            ad.setPositiveButton("네",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent = new Intent(MainActivity.this,Dic.class);
                    startActivity(intent);
                    /*db에저장한것을 불러와 adapter에 넣어주어야한다*/
                   /* adapter.addItem(ContextCompat.getDrawable(MainActivity.this,R.drawable.tulip),"튤립","2017년 8월 3일");
                    listview.setAdapter(adapter);
                    dialog.dismiss();*/
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
            Intent intent = new Intent(MainActivity.this,Dic.class);
            startActivity(intent);


           
        }
            return super.onOptionsItemSelected(item);
    }
    public void getInstanceIdToken(){
        if(checkPlayServices()){
            Intent intent = new Intent(this,com.example.kimsoohyun.planiotver00.service.fcm.RegistrationIntentService.class);
            startService(intent);
        }
    }
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }


    public void registerBroadcastReceiver(){
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                if (action.equals(com.example.kimsoohyun.planiotver00.service.fcm.QuickstartPreferences.REGISTRATION_READY)) {

                } else if (action.equals(com.example.kimsoohyun.planiotver00.service.fcm.QuickstartPreferences.REGISTRATION_GENERATING)) {

                } else if (action.equals(com.example.kimsoohyun.planiotver00.service.fcm.QuickstartPreferences.REGISTRATION_COMPLETE)) {
                    String token = intent.getStringExtra("token");
                    String register_id = token;
                    Log.d("json token fcm id : ", register_id);
                    //loginFacebook
                }
            }
        };
    }



}
