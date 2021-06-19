package com.salem.biblequiz.Base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.salem.biblequiz.R;


public class AppConfig extends Application  {
    private  Context mContext;
    static SharedPreferences sharedPref;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        sharedPref = mContext.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPref() {
        return sharedPref;
    }

}
