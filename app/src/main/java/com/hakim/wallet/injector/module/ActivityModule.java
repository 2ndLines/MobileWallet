package com.hakim.wallet.injector.module;

import android.content.Context;

import com.hakim.wallet.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context){
        this.context = context;
    }

    @Provides @PerActivity Context provideActivityContext(){
        return context;
    }

}
