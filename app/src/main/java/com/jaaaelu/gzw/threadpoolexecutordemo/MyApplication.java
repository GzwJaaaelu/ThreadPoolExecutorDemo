package com.jaaaelu.gzw.threadpoolexecutordemo;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(mContext);
    }

    /**
     * 获取App的上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }


}