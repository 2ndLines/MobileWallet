package com.hakim.wallet.injector.module;

import com.hakim.wallet.domain.CardDetailUserCase;
import com.hakim.wallet.domain.CardListUserCase;
import com.hakim.wallet.domain.SmallChangeUserCase;
import com.hakim.wallet.injector.PerActivity;
import com.hakim.wallet.model.repository.CardRepository;
import com.hakim.wallet.model.repository.SmallChangeRepository;

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
public class WalletModule {


    public WalletModule(){}

    @Provides @PerActivity
    CardDetailUserCase provideCardDetailUserCase(CardRepository repository){
        return new CardDetailUserCase(repository);
    }

    @Provides @PerActivity
    CardListUserCase provideCardListUserCase(CardRepository repository){
        return new CardListUserCase(repository);
    }

    @Provides @PerActivity
    SmallChangeUserCase provideSmallChangeUserCase(SmallChangeRepository repository){
        return new SmallChangeUserCase(repository);
    }
}
