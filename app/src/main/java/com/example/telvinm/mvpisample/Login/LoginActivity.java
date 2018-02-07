package com.example.telvinm.mvpisample.Login;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.telvinm.mvpisample.R;
import com.example.telvinm.mvpisample.Utilities.Constant;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginView
{
    @BindViews({R.id.tv_password_error,R.id.tv_email_error})
    protected TextView tvErrorPassword,tvErrorEmail;
    @BindViews({R.id.et_email,R.id.et_password})
    protected EditText etEmail,etPassword;
    Unbinder unbinder;
    private LoginPresenter mPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mPresenter.setAutoFillEmail();
    }

    @OnClick({R.id.btn_register, R.id.btn_skip, R.id.btn_login, R.id.btn_forgot_password})
    public void onButtonClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_login:
                mPresenter.loginHandle();
                break;
            case R.id.btn_register:
                mPresenter.showNextScreen(Constant.REGISTER);
                break;
            case R.id.btn_forgot_password:
                mPresenter.showNextScreen(Constant.FORGOT_PASSWORD);
                break;
            case R.id.btn_skip:
                mPresenter.showNextScreen(Constant.HOMEPAGE);
                break;
        }
    }

    @Override
    public AppCompatActivity getActivity()
    {
        return getActivity();
    }

    @Override
    public void setEmailText(String savedEmail)
    {
        etEmail.setText(savedEmail);
    }

    @Override
    public EditText getEmailEditText()
    {
        return etEmail;
    }

    @Override
    public EditText getPasswordEditText()
    {
        return etPassword;
    }

    @Override
    public TextView getEmailErrorTextView()
    {
        return tvErrorEmail;
    }

    @Override
    public TextView getPasswordErrorTextView()
    {
        return tvErrorPassword;
    }

    @Override
    public void dismissDialog()
    {
        progressDialog.show();
    }
}
