package com.example.anshul.p1;

import android.app.Application;

/**
 * Created by Anshul on 1/16/2018.
 */

public class font extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/proxynova2.ttf");
       // FontsOverride.setDefaultFont(this, "SERIF", "fonts/proxynova.ttf");
    }
}
