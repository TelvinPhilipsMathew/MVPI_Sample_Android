package com.example.telvinm.mvpisample.ServiceHelper.persistence.sharedpref;

/**
 * Created by Anoop S S on 11/4/16.
 */
public interface ISharedPrefServices {

    void saveString(String key, String value);

    String getString(String key);
}
