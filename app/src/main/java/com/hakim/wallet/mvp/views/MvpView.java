package com.hakim.wallet.mvp.views;

import android.content.Context;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public interface MvpView {
    Context getContext();

    void showLoading();

    void hideLoading();

    void showError(String message);
}
