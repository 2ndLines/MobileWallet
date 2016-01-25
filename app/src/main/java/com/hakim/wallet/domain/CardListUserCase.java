package com.hakim.wallet.domain;

import com.hakim.wallet.model.entities.Card;
import com.hakim.wallet.model.repository.CardRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */

public class CardListUserCase implements UserCase<List<Card>> {
    private final CardRepository repository;

    @Inject
    public CardListUserCase(CardRepository repository){
        this.repository = repository;
    }

    @Override
    public Observable<List<Card>> execute(String key) {
        return repository.cardList(key);
    }
}
