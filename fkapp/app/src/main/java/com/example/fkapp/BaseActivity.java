package com.example.fkapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.analytics.Tracker;

public class BaseActivity extends AppCompatActivity {

    private Tracker mTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //google分析
        com.example.fkapp.App application = (com.example.fkapp.App) getApplication();
        mTracker = application.getDefaultTracker();
    }

    public Tracker getTracker() {
        return mTracker;
    }
}
