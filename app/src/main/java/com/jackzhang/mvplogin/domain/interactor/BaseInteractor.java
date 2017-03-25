package com.jackzhang.mvplogin.domain.interactor;


/**
 * Interactor用来获取Model(本地获取或者网络获取)，回调通知把Model传递给Presenter。
 */
public interface BaseInteractor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    void execute();
}
