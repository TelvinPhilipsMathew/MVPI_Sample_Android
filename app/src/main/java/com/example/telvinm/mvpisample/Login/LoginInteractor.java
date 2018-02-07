package com.example.telvinm.mvpisample.Login;

import com.example.telvinm.mvpisample.Utilities.Constant;
import com.example.telvinm.mvpisample.dataModels.LoginRequestModel;
import com.example.telvinm.mvpisample.dataModels.LoginResponseModel;
import com.example.telvinm.mvpisample.MVPICore.BaseInteractor;
import com.example.telvinm.mvpisample.R;
import com.example.telvinm.mvpisample.Utilities.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by telvin.m on 09-05-2017.
 */

public class LoginInteractor extends BaseInteractor<LoginPresenter>
{
    public LoginInteractor(LoginPresenter presenter)
    {
        super(presenter);
    }

    public void callLoginApi(String email, String password)
    {

        LoginRequestModel loginRequestModel = new LoginRequestModel(email, password);
        Call<List<LoginResponseModel>> loginResponce = getServices().getNetworkServices().getLoginResponce(loginRequestModel);
        loginResponce.enqueue(new Callback<List<LoginResponseModel>>()
        {
            @Override
            public void onResponse(Call<List<LoginResponseModel>> call, Response<List<LoginResponseModel>> response)
            {
                try
                {
                    getPresenter().getView().dismissDialog();
                    if (response != null)
                    {
                        List<LoginResponseModel> loginResponse = response.body();
                        if (loginResponse != null && loginResponse.size() >= 0)
                        {
                            LoginResponseModel loginResponseModel = loginResponse.get(0);
                            if (loginResponseModel != null)
                            {
                                String loginStatus = loginResponseModel.getLoginStatus();
                                if (getPresenter().isLoginStatusSuccess(loginStatus))
                                {
                                    if (!Constant.CLIENT_TYPE.GUEST_USER.equals(loginResponseModel.getType()))
                                    {
                                        if (loginResponseModel.getClientId() == 0)
                                        {
                                            getPresenter().showErrorLogin(getPresenter().TYPE_EMAIL, getPresenter().getContext().getString(R.string.message_not_client_user));
                                            return;
                                        }
                                        //sharedPrefHanlder.saveString(SharedPrefKeys.SAVED_EMAIL, "");


                                    }
                                    getPresenter().gotoHomeScreen();
                                }
                            } else
                            {
                                Utils.showMessage(getPresenter().getContext().getString(R.string.unknown_api_error),getPresenter().getContext());
                            }
                        } else
                        {
                            Utils.showMessage(getPresenter().getContext().getString(R.string.unknown_api_error),getPresenter().getContext());
                        }
                    } else
                    {
                        Utils.showMessage(getPresenter().getContext().getString(R.string.unknown_api_error),getPresenter().getContext());
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<LoginResponseModel>> call, Throwable t)
            {
                try
                {
                    getPresenter().getView().dismissDialog();
                    if (!Utils.isNetWorkAvailable(getPresenter().getContext()))
                    {
                        Utils.showMessage(getPresenter().getContext().getString(R.string.unknown_api_error),getPresenter().getContext());
                        return;
                    }
                    Utils.showMessage(getPresenter().getContext().getString(R.string.unknown_api_error),getPresenter().getContext());
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
