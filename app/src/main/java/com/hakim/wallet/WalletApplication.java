package com.hakim.wallet;

import android.app.Application;

import com.hakim.wallet.injector.component.AppComponent;
import com.hakim.wallet.injector.component.DaggerAppComponent;
import com.hakim.wallet.injector.module.AppModule;

/**
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
public class WalletApplication extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector(){
        this.component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent component(){
        return component;
    }
}
