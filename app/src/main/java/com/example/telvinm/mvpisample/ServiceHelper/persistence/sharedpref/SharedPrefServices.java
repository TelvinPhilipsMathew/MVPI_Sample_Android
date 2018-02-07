package com.example.telvinm.mvpisample.ServiceHelper.persistence.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Anoop S S on 11/4/16.
 */
public class SharedPrefServices implements ISharedPrefServices{

    private static final String MOBINION_PREFS = "Sample_Pref";

    private SharedPreferences mSharedPrefs;

    public SharedPrefServices(Context context) {
        mSharedPrefs = context.getSharedPreferences(MOBINION_PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public String getString(String key) {
        return mSharedPrefs.getString(key, null);
    }
}
