package com.pc.mykotlin.umapp;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Helloworld on 2017/12/29.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "5a46016bf29d9830ee000042", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "c97586523e113587d540f00e3e642db6");
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("AAA",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
