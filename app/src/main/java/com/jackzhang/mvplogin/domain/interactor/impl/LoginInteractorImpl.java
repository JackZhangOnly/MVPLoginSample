package com.jackzhang.mvplogin.domain.interactor.impl;

import android.os.Handler;

import com.jackzhang.mvplogin.domain.interactor.LoginInteractor;

/**
 * Created by Jack on 2017/3/25.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final CallBack callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if ("jack".equals(username)&&"123".equals(password)){
                    callBack.onLoginResponse(true,"");
                }else {
                    callBack.onLoginResponse(false,"用户名或密码错误");

                }
            }
        }, 2000);
    }

}
