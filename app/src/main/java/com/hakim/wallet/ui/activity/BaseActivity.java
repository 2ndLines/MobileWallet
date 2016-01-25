package com.hakim.wallet.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hakim.wallet.WalletApplication;
import com.hakim.wallet.injector.component.AppComponent;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    protected abstract void initializeInjector();

    protected AppComponent getAppComponent() {
        return ((WalletApplication) getApplication()).component();
    }

    public abstract <T> T getActivityComponent();
}
