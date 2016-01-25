package com.hakim.wallet.domain;

import com.hakim.wallet.model.entities.Card;
import com.hakim.wallet.model.repository.CardRepository;

import javax.inject.Inject;

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
public class CardDetailUserCase implements UserCase<Card> {
    private final CardRepository repository;

    @Inject
    public CardDetailUserCase(CardRepository repository){
        this.repository = repository;
    }

    @Override
    public Observable<Card> execute(String key) {
        return repository.card(key);
    }
}
