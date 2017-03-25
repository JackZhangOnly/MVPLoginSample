package com.jackzhang.mvplogin.presenter;

import com.jackzhang.mvplogin.ui.BaseView;

/**
 * Created by Jack on 2017/3/19.
 */

public interface LoginPresenter extends BasePresenter{

    interface View extends BaseView{
        /**
         * to main activity
         */
        void toMain();

        /**
         * get username and password
         * @return
         */
        String getUserName();
        String getPassword();
    }

    /**
     * login
     */
    void doLogin();
}
