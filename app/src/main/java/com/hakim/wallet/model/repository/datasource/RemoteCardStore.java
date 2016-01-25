package com.hakim.wallet.model.repository.datasource;

import com.hakim.wallet.model.entities.Card;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :  远程的卡片数据缓存
 *
 */

@Singleton
public class RemoteCardStore implements CardStore {
    @Inject
    public RemoteCardStore(){

    }

    @Override
    public void putCard(Card card) {

    }

    @Override
    public Observable<Card> cardDetail(String cardId) {
        return null;
    }

    @Override
    public Observable<List<Card>> cardList(String cardType) {
        return null;
    }
}
