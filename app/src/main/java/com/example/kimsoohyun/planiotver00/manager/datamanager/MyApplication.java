package com.example.kimsoohyun.planiotver00.manager.datamanager;

import android.app.Application;
import android.content.Context;

/**
 * Created by kimsoohyun on 2017-08-23.
 */
public class MyApplication extends Application {
    static Context context;

    public static Context getContext() {
        return context; //자원을 반환.//
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this; //현재 어플리케이션의 자원을 얻어온다.//
    }
}
