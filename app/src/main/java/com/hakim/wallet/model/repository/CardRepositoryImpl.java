package com.hakim.wallet.model.repository;

import com.hakim.wallet.model.entities.Card;
import com.hakim.wallet.model.repository.datasource.CardStore;
import com.hakim.wallet.model.repository.datasource.CardStoreFactory;

import java.util.List;

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
public class CardRepositoryImpl implements CardRepository {
    private final CardStoreFactory cardFactory;

    @Inject
    public CardRepositoryImpl(CardStoreFactory factory) {
        this.cardFactory = factory;
    }


    @Override
    public Observable<Card> card(String cardId) {
        //Retrieve from local disk
        return cardFactory.createLocalStore()
                .cardDetail(cardId);

    }

    @Override
    public Observable<List<Card>> cardList(final String cardType) {
        return cardFactory.create(cardType)
                .flatMap(new Func1<CardStore, Observable<List<Card>>>() {
                    @Override
                    public Observable<List<Card>> call(CardStore cardStore) {
                        return cardStore.cardList(cardType);
                    }
                });

    }
}
