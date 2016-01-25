package com.hakim.wallet.injector.component;

import android.content.Context;

import com.hakim.wallet.injector.PerActivity;
import com.hakim.wallet.injector.module.ActivityModule;

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

@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    Context context();
}
