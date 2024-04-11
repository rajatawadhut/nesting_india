package com.nesting_india_property.property;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AudienceNetworkAds.initialize(BaseApplication.this);
    }
}
