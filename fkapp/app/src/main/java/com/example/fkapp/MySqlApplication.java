package com.example.fkapp;

import android.app.Application;

import org.xutils.x;


public class MySqlApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
