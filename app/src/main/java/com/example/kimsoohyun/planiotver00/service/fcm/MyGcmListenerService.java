package com.example.kimsoohyun.planiotver00.service.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.kimsoohyun.planiotver00.R;
import com.example.kimsoohyun.planiotver00.manager.datamanager.PropertyManager;
import com.example.kimsoohyun.planiotver00.splashActivity;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by kimsoohyun on 2017-08-23.
 */
public class MyGcmListenerService extends GcmListenerService{
    private static final String TAG = "MYGcmListenerService";
    int badge_count;

    @Override
    public void onMessageReceived(String from, Bundle data){
        String title = data.getString("TITLE");
        String message = data.getString("MSG");

        Log.d(TAG,"From:"+from);
        Log.d(TAG,"Title:"+title);
        Log.d(TAG,"Message:"+message);
        sendNotification(title,message);
        set_alarm_badge();
    }


    private void sendNotification(String title, String message){
        Intent intent = new Intent(this,splashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }

    public void set_alarm_badge() {
        Log.d("json control","notify receive");
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");

        badge_count = PropertyManager.getInstance().get_badge_number();
        badge_count++;

        intent.putExtra("badge_count",badge_count);
        intent.putExtra("badge_count_package_name",getApplicationContext().getPackageName());
        intent.putExtra("badge_count_class_name",splashActivity.class.getName());

        Intent i = new Intent("android.intent.action.BADGE_COUNT_UPDATE");

        i.putExtra("badge_count",0);
        i.putExtra("badge_count_package_name",getApplicationContext().getPackageName());
        i.putExtra("badge_count_class_name",splashActivity.class.getName());

        PropertyManager.getInstance().setBadge_number(0);

        sendBroadcast(i);
    }

}
