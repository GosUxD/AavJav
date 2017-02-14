package com.aavjaav.qd.aavjaav;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Street.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
