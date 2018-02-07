package com.example.telvinm.mvpisample.ServiceHelper.shared;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created  on 08-03-2017.
 */

public class SharedPreferenceHandler
{

    private static SharedPreferences preferences;
    private static String SHRARED_PREF_NAME = "smartord";
    private static SharedPreferenceHandler sharedPreferenceHandler;

    public static SharedPreferenceHandler getInstance(Context context)
    {
        if (preferences == null)
        {
            preferences = context.getSharedPreferences(SHRARED_PREF_NAME, context.MODE_PRIVATE);
        }
        if (sharedPreferenceHandler == null)
            sharedPreferenceHandler = new SharedPreferenceHandler();
        return sharedPreferenceHandler;
    }

    public void saveString(String key, String value)
    {
        preferences.edit().putString(key, value).apply();
    }

    public void saveInt(String key, int value)
    {
        preferences.edit().putInt(key, value).apply();
    }

    public void saveBoolean(String key, Boolean value)
    {
        preferences.edit().putBoolean(key, value).apply();
    }

    public String getString(String key)
    {
        return preferences.getString(key, "");
    }

    public Boolean getBoolean(String key)
    {
        return preferences.getBoolean(key, false);
    }

    public Integer getInt(String key)
    {
        return preferences.getInt(key, 0);
    }
}
