package com.smile.testmobservice.application;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by wuqi on 2018/8/9.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
    }
}
