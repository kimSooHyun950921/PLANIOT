package com.example.kimsoohyun.planiotver00.service.fcm;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by kimsoohyun on 2017-08-23.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService{
    private static final String Tag = "MyInstanceIDLS";
    @Override
    public void onTokenRefresh(){
        Intent intent = new Intent(this,RegistrationIntentService.class);
        startService(intent);
    }
}
