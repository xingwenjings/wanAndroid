package com.example.wan_android.base;

import android.app.Application;
import android.content.res.Resources;
import android.support.v7.app.AppCompatDelegate;

import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.UIModeUtil;

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

    public static Resources getRes() {
        return sBaseApp.getResources();
    }

}
