package com.example.telvinm.mvpisample.ServiceHelper;

import android.content.Context;

import com.example.telvinm.mvpisample.ServiceHelper.async.AsyncJobServicesImpl;
import com.example.telvinm.mvpisample.ServiceHelper.async.IAsyncJobServices;
import com.example.telvinm.mvpisample.ServiceHelper.network.INetworkServices;
import com.example.telvinm.mvpisample.ServiceHelper.network.NetworkServicesImpl;
import com.example.telvinm.mvpisample.ServiceHelper.persistence.IPersistenceServices;
import com.example.telvinm.mvpisample.ServiceHelper.persistence.PersistenceServiceImpl;




public class ServiceHolder {

    private static volatile ServiceHolder sInstance;

    //NetworkServices instance
    INetworkServices mNetworkServices;

    //StorageServices instance
    IPersistenceServices mPersistenceServices;

    //AsyncRunner instance
    IAsyncJobServices mAsyncJobServices;

    /**
     * @param context
     * @return Singleton instance of the ServiceHolder class
     */
    public static ServiceHolder getInstance(Context context){
        if(null == sInstance){
            synchronized (ServiceHolder.class){
                sInstance = new ServiceHolder(context);
            }
        }

        return sInstance;
    }

    /**
     * Constructor is made private to make sure that outside classes can't instantiate it to constructor.
     * Thus sticking to the singleton pattern
     * @param context
     */
    private ServiceHolder(Context context){
        mNetworkServices = NetworkServicesImpl.getInstance();
        mPersistenceServices = PersistenceServiceImpl.getInstance(context);
        mAsyncJobServices = AsyncJobServicesImpl.getInstance();
    }

    /**
     * @return Singleton instance of the {@Link INetworkServices} for interactors to make API calls
     */
    public INetworkServices getNetworkServices(){
        return mNetworkServices;
    }

    /**
     * @return Singleton instance of the {@Link IPersistenceServices} for interactors to use storage and retrieval methods
     */
    public IPersistenceServices getPersistenceServices(){
        return mPersistenceServices;
    }

    /**
     * @return Singleton instance of the {@Link IAsyncJobServices} for interactors to carry out long running tasks
     */
    public IAsyncJobServices getAsyncJobServices(){
        return mAsyncJobServices;
    }

}
