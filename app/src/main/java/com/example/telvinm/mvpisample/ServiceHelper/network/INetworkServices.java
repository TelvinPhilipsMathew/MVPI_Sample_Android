package com.example.telvinm.mvpisample.ServiceHelper.network;


import com.example.telvinm.mvpisample.Utilities.Constant;
import com.example.telvinm.mvpisample.dataModels.LoginRequestModel;
import com.example.telvinm.mvpisample.dataModels.LoginResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Declares all the api call methods here
 */
public interface INetworkServices {


    @POST(Constant.API_ENDPOINTS.LOGIN)
    Call<List<LoginResponseModel>> getLoginResponce(@Body LoginRequestModel loginRequestModel);

}
