package com.hakim.wallet.model.repository.datasource;

import com.hakim.wallet.model.entities.Card;

import java.util.List;

import rx.Observable;

/**
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public interface CardStore {

    void putCard(Card card);

    Observable<Card> cardDetail(String cardId);

    Observable<List<Card>> cardList(String cardType);


}
