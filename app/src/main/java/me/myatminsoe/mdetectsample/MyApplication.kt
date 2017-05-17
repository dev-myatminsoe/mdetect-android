package me.myatminsoe.mdetectsample

import android.app.Application

import me.myatminsoe.mdetect.MDetect

/**
 * Created by myatminsoe on 4/20/17.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MDetect.init(this)
    }
}
