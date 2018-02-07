package com.example.telvinm.mvpisample.ServiceHelper.async;

import android.os.AsyncTask;

import com.example.telvinm.mvpisample.ServiceHelper.async.runner.AsyncJob;
import com.example.telvinm.mvpisample.ServiceHelper.async.runner.CancellableAsyncRunner;


public class AsyncJobServicesImpl implements IAsyncJobServices{

    private static volatile AsyncJobServicesImpl sInstance;

    public static AsyncJobServicesImpl getInstance(){
        if(null == sInstance){
            synchronized (AsyncJobServicesImpl.class){
                sInstance = new AsyncJobServicesImpl();
            }
        }

        return sInstance;
    }

    private AsyncJobServicesImpl(){}

    @Override
    public CancellableAsyncRunner runAsyncJob(AsyncJob asyncJob) {
        CancellableAsyncRunner cancellableAsyncRunner = new CancellableAsyncRunner(asyncJob);
        cancellableAsyncRunner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        return cancellableAsyncRunner;
    }
}
