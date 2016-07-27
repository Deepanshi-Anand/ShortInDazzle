package com.indazzlenew.splash;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 24-06-2016.
 */
public class AllPrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mycontext;

    int PRIVATE_MODE=0;
    private static final String PREF_NAME = "Glimray";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public AllPrefManager(Context context) {
        this.mycontext = context;
        pref = mycontext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
        //editor.apply();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
