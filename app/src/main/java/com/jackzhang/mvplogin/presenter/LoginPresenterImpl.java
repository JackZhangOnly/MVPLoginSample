package com.jackzhang.mvplogin.presenter;

import com.jackzhang.mvplogin.domain.interactor.LoginInteractor;
import com.jackzhang.mvplogin.domain.interactor.impl.LoginInteractorImpl;

/**
 * Created by Jack on 2017/3/25.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginPresenter.View mLoginView;
    @Override
    public void doLogin() {

        final String userName=mLoginView.getUserName();
        final String password=mLoginView.getPassword();

        if ("".equals(userName)){
            mLoginView.showError("Username is required!");
            return;
        }
        if ("".equals(password)){
            mLoginView.showError("Password is required!");
            return;
        }

        mLoginView.showProgress();
        //call login Interator
        LoginInteractor loginInterator=new LoginInteractorImpl();
        loginInterator.login(userName, password, new LoginInteractor.CallBack() {
            @Override
            public void onLoginResponse(boolean success, String msg) {
                mLoginView.hideProgress();
                if (success){
                    mLoginView.toMain();
                }else {
                    mLoginView.showError(msg);
                }
            }
        });
    }


    public LoginPresenterImpl(View view){
        this.mLoginView=view;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

}
