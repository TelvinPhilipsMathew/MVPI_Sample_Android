package com.example.telvinm.mvpisample.ServiceHelper.async;


import com.example.telvinm.mvpisample.ServiceHelper.async.runner.AsyncJob;
import com.example.telvinm.mvpisample.ServiceHelper.async.runner.CancellableAsyncRunner;

public interface IAsyncJobServices {

    CancellableAsyncRunner runAsyncJob(AsyncJob asyncJob);
}
