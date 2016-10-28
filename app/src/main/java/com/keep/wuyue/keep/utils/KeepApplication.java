package com.keep.wuyue.keep.utils;

import android.app.Application;
import android.content.Context;

import com.tencent.android.tpush.XGPushManager;

/**
 * Created by wuyue on 2016/10/27.
 */

public class KeepApplication extends Application{

    private Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        XGPushManager.registerPush(mContext);
    }
}
