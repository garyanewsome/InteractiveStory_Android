package com.teamtreehouse.interactivestory

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle

class InteractiveStoryApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity:Activity, savedInstanceState:Bundle?) {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            }
            override fun onActivityStarted(activity:Activity) {
            }
            override fun onActivityResumed(activity:Activity) {
            }
            override fun onActivityPaused(activity:Activity) {
            }
            override fun onActivityStopped(activity:Activity) {
            }
            override fun onActivitySaveInstanceState(activity:Activity, outState:Bundle) {
            }
            override fun onActivityDestroyed(activity:Activity) {
            }
        })
    }
}