package com.hakim.wallet.model.repository.datasource;

import com.hakim.wallet.cache.CardCache;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */

@Singleton
public class CardStoreFactory {

    private final CardCache cardCache;

    @Inject
    public CardStoreFactory(CardCache cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Constructor params can not be null !");
        }
        this.cardCache = cache;
    }

    public CardStore createLocalStore() {
        return new LocalCardStore(cardCache);
    }


    public Observable<CardStore> create(String cardType) {
        return cardCache.isCached(cardType)
                .map(new Func1<Boolean, CardStore>() {
                    @Override
                    public CardStore call(Boolean aBoolean) {
                        if (aBoolean) {
                            return createLocalStore();
                        } else {
                            return createRemoteStore();
                        }

                    }
                });

    }

    public CardStore createRemoteStore() {
        return new RemoteCardStore();
    }
}

