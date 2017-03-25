package com.jackzhang.mvplogin;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jackzhang.mvplogin.presenter.LoginPresenter;
import com.jackzhang.mvplogin.presenter.LoginPresenterImpl;
import com.jackzhang.mvplogin.ui.BaseActivity;
import com.wang.avi.AVLoadingIndicatorView;

/**
 *
 */
public class LoginActivity extends BaseActivity implements LoginPresenter.View{

    private EditText uName;
    private EditText uPassword;
    private LoginPresenter loginPresenter;
    private AVLoadingIndicatorView avi;


    @Override
    public void initVariable() {
        loginPresenter=new LoginPresenterImpl(this);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);

        uName=(EditText) findViewById(R.id.login_uname);
        uPassword= (EditText) findViewById(R.id.login_upassword);
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);

        findViewById(R.id.login_loginbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin();
            }
        });
    }

    @Override
    public void dataProcessing() { }

    @Override
    public String getUserName() {
        return uName.getText().toString();
    }

    @Override
    public String getPassword() {
        return uPassword.getText().toString();
    }


    @Override
    public void showProgress() {
        avi.show();
    }
    @Override
    public void hideProgress() {
        avi.hide();
    }
    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void toMain() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
