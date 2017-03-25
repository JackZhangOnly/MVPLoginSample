package com.jackzhang.mvplogin.domain.interactor;

/**
 * Created by Jack on 2017/3/19.
 */

public interface LoginInteractor {

    interface CallBack{
        void onLoginResponse(boolean success,String msg);
    }
    public void login(String username,String password,CallBack callBack);
}
