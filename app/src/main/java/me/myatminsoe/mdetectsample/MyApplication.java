package me.myatminsoe.mdetectsample;

import android.app.Application;

import me.myatminsoe.mdetect.MDetect;

/**
 * Created by myatminsoe on 4/20/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MDetect.init(this);
    }
}
