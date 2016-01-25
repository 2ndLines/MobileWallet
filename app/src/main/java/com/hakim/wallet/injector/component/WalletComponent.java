package com.hakim.wallet.injector.component;

import com.hakim.wallet.domain.SmallChangeUserCase;
import com.hakim.wallet.injector.PerActivity;
import com.hakim.wallet.injector.module.ActivityModule;
import com.hakim.wallet.injector.module.WalletModule;
import com.hakim.wallet.ui.activity.HomeActivity;
import com.hakim.wallet.ui.fragment.SmallChangeFragment;

import dagger.Component;

/**
 * Author   ：	Hakim Shi
 * Email    :  hakim.shi@qq.com
 * CreatedAt：	2016/1/21
 * <p/>
 * Summary  :
 */

@PerActivity
@Component(modules = {WalletModule.class, ActivityModule.class}, dependencies = AppComponent.class)
public interface WalletComponent extends ActivityComponent {
    void inject(HomeActivity activity);

    void inject(SmallChangeFragment fragment);

    SmallChangeUserCase smallChangeUserCase();
}
