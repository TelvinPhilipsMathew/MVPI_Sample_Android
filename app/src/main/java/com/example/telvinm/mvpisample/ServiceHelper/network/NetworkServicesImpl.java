package com.example.telvinm.mvpisample.ServiceHelper.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Implementation of {@Link INetworkServices} interface with {@Link Retrofit} library
 */
public class NetworkServicesImpl implements INetworkServices {

    //Singleton instance
    private static volatile NetworkServicesImpl sInstance;

    //Retrofit instance
    private Retrofit mRetrofit = null;

    //APIServices instance
    APIServices mAPIServices = null;

    /**
     * @return Singleton instance of the ServiceHolder class
     */
    public static INetworkServices getInstance() {
        if (null == sInstance) {
            synchronized (NetworkServicesImpl.class) {
                sInstance = new NetworkServicesImpl();
            }
        }

        return sInstance;
    }

    /**
     * Constructor is made private to make sure that outside classes can't instantiate it to constructor.
     * Thus sticking to the singleton pattern
     */
    private NetworkServicesImpl() {

        //Initing the retrofit instance with the Base URL based on the build type
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Iniiting the api service interface
        mAPIServices = mRetrofit.create(APIServices.class);
    }


}
