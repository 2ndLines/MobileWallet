package com.hakim.wallet.injector.component;

import com.hakim.wallet.WalletApplication;
import com.hakim.wallet.injector.module.AppModule;
import com.hakim.wallet.model.repository.CardRepository;
import com.hakim.wallet.model.repository.SmallChangeRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(WalletApplication application);

    WalletApplication application();

}
