package com.hakim.wallet.mvp.presenter;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public interface Presenter {

    void onCreate();

    void onPause();

    void onResume();

    void onDestroy();
}
