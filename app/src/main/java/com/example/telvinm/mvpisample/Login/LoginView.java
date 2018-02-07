package com.example.telvinm.mvpisample.Login;

import android.widget.EditText;
import android.widget.TextView;

import com.example.telvinm.mvpisample.MVPICore.BaseView;

/**
 * Created by telvin.m on 09-05-2017.
 */

public interface LoginView extends BaseView
{
    void setEmailText(String savedEmail);

    EditText getEmailEditText();

    EditText getPasswordEditText();

    TextView getEmailErrorTextView();

    TextView getPasswordErrorTextView();

    void dismissDialog();
}
