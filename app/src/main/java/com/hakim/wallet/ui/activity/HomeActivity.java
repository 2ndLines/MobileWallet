package com.hakim.wallet.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hakim.wallet.injector.component.DaggerWalletComponent;
import com.hakim.wallet.injector.component.WalletComponent;
import com.hakim.wallet.injector.module.ActivityModule;
import com.hakim.wallet.injector.module.WalletModule;
import com.hakim.wallet.ui.fragment.SmallChangeFragment;

/**
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
public class HomeActivity extends BaseActivity {
    private WalletComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showFragment(new SmallChangeFragment());
        getActivityComponent().inject(this);
    }

    @Override
    protected void initializeInjector(){
        this.component = DaggerWalletComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(new ActivityModule(this))
                .walletModule(new WalletModule())
                .build();
    }

    @SuppressWarnings("unchecked")
    @Override
    public WalletComponent getActivityComponent() {
        return component;
    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();

    }
}
