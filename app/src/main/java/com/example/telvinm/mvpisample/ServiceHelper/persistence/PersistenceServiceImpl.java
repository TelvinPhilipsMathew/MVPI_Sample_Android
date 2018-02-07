package com.example.telvinm.mvpisample.ServiceHelper.persistence;

import android.content.Context;

import com.mobinion.service.persistence.sharedpref.ISharedPrefServices;
import com.mobinion.service.persistence.sharedpref.SharedPrefServices;

/**
 * Created by anoop on 11/4/16.
 */
public class PersistenceServiceImpl implements IPersistenceServices {

    private static volatile PersistenceServiceImpl sInstance;

    private ISharedPrefServices mSharedPrefServices;

    public static PersistenceServiceImpl getInstance(Context context){
        if(null == sInstance){
            sInstance = new PersistenceServiceImpl(context);
        }

        return sInstance;
    }

    private PersistenceServiceImpl(Context context){
        mSharedPrefServices = new SharedPrefServices(context);
    }

    @Override
    public void saveString(String key, String value) {
        mSharedPrefServices.saveString(key, value);
    }

    @Override
    public String getString(String key) {
        return mSharedPrefServices.getString(key);
    }
}
