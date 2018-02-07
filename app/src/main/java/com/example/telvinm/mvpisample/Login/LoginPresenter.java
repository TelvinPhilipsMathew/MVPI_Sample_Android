package com.example.telvinm.mvpisample.Login;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;

import com.example.telvinm.mvpisample.Utilities.Constant;
import com.example.telvinm.mvpisample.MVPICore.BasePresenter;
import com.example.telvinm.mvpisample.R;
import com.example.telvinm.mvpisample.ServiceHelper.shared.SharedPrefKeys;
import com.example.telvinm.mvpisample.ServiceHelper.shared.SharedPreferenceHandler;
import com.example.telvinm.mvpisample.Utilities.Utils;


/**
 * Created by telvin.m on 09-05-2017.
 */

public class LoginPresenter extends BasePresenter<LoginView>
{
    private LoginInteractor mLoginInteractor;
    private SharedPreferenceHandler sharedPrefHanlder;

    public static final String TYPE_EMAIL = "email";
    private static final String TYPE_PASSWORD = "password";
    @Override
    protected void onAttached()
    {
        mLoginInteractor = new LoginInteractor(this);
        sharedPrefHanlder = SharedPreferenceHandler.getInstance(getContext());
    }

    /**
     * Show previous email when user visits again
     */
    public void setAutoFillEmail()
    {
        String savedEmail = sharedPrefHanlder.getString(SharedPrefKeys.SAVED_EMAIL);
        if (!TextUtils.isEmpty(savedEmail))
        {
            getView().setEmailText(savedEmail);
        } else
        {
            String username = sharedPrefHanlder.getString(SharedPrefKeys.USERNAME);
            if (!TextUtils.isEmpty(username))
            {
                getView().setEmailText(username);
            }
        }
    }

    /**
     * Handle login button click
     */
    public void loginHandle()
    {
        if (!Utils.isNetWorkAvailable(getContext()))
        {
            Utils.showMessage(getContext().getString(R.string.no_internet_connection),getContext());
            return;
        }
        resetAllErrorMessage();
        if (isLoginCredentialsValid(getView().getEmailEditText().getText().toString(), getView().getPasswordEditText().getText().toString()))
        {
            mLoginInteractor.callLoginApi(getView().getEmailEditText().getText().toString(), getView().getPasswordEditText().getText().toString());
        }
    }
    /**
     * Validating Login Status and showing appropriate error message
     *
     * @param loginStatus
     * @return
     */
    public boolean isLoginStatusSuccess(String loginStatus)
    {
        Boolean isLoginSuccess = false;
        if (Constant.LoginResponseStatus.SUCCESS.equals(loginStatus))
        {
            isLoginSuccess = true;
        } else if (Constant.LoginResponseStatus.INVALID_PASSWORD.equals(loginStatus))
        {
            // showMessage(getString(R.string.MESSAGE_INVALID_PASSWORD));
            showErrorLogin(TYPE_PASSWORD, getContext().getString(R.string.error_password));
            isLoginSuccess = false;
        } else if (Constant.LoginResponseStatus.INVALID_USERNAME.equals(loginStatus))
        {
            // showMessage(getString(R.string.MESSAGE_INVALID_EMAIL));
            showErrorLogin(TYPE_EMAIL, getContext().getString(R.string.error_email));
            isLoginSuccess = false;
        } else if (Constant.LoginResponseStatus.INVALID_EMAIL_OR_PASSWORD.equals(loginStatus))
        {
            //  showMessage(getString(R.string.invalid_username_or_password));
            showErrorLogin(TYPE_EMAIL, getContext().getString(R.string.error_email));
            showErrorLogin(TYPE_PASSWORD, getContext().getString(R.string.error_password));
            isLoginSuccess = false;
        }
        return isLoginSuccess;
    }
    /**
     * validating login credentials
     * @param email
     * @param password
     * @return
     */
    private boolean isLoginCredentialsValid(String email, String password)
    {
        Boolean isValidCredentials = true;
        if (!TextUtils.isEmpty(email))
        {
            if (!Utils.emailValidator(email.trim()))
            {
                showErrorLogin(TYPE_EMAIL, getContext().getString(R.string.error_email));
                isValidCredentials = false;
            }
        } else
        {
            showErrorLogin(TYPE_EMAIL, getContext().getString(R.string.error_email));
            isValidCredentials = false;
        }
        if (TextUtils.isEmpty(password.trim()))
        {
            showErrorLogin(TYPE_PASSWORD, getContext().getString(R.string.error_password));
            isValidCredentials = false;
        }
        return isValidCredentials;
    }

    /**
     * Handling error message in login screen
     * @param type
     * @param message
     */
    public void showErrorLogin(String type, String message)
    {
        switch (type)
        {
            case TYPE_EMAIL:
                // showMessage(getString(R.string.MESSAGE_INVALID_EMAIL));
                getView().getEmailEditText().requestFocus();
                getView().getEmailErrorTextView().setVisibility(View.VISIBLE);
                getView().getEmailErrorTextView().setText(message);
                getView().getEmailEditText().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.white_rect_with_red_border));
                getView().getEmailEditText().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_form_mail_error, 0, 0, 0);
                break;
            case TYPE_PASSWORD:

                getView().getPasswordEditText().requestFocus();
                // showMessage(getString(R.string.MESSAGE_INVALID_PASSWORD));
                getView().getPasswordErrorTextView().setVisibility(View.VISIBLE);
                getView().getPasswordErrorTextView().setText(message);
                getView().getPasswordEditText().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.white_rect_with_red_border));
                getView().getPasswordEditText().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_form_pass_error, 0, 0, 0);
                break;
        }
    }

    /**
     * Reset all error message in login screen
     */
    private void resetAllErrorMessage()
    {
        getView().getEmailErrorTextView().setVisibility(View.GONE);
        getView().getEmailEditText().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.white_rect_with_grey_border));
        getView().getEmailEditText().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_form_mail, 0, 0, 0);
        getView().getPasswordErrorTextView().setVisibility(View.GONE);
        getView().getPasswordEditText().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.white_rect_with_grey_border));
        getView().getPasswordEditText().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_form_pass, 0, 0, 0);

    }

    public void gotoHomeScreen()
    {
        //showNextScreen();
    }

    public void showNextScreen(String nextscreen)
    {
        //navigate to next screen
    }
}
