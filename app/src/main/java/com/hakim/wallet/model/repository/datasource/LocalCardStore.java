package com.hakim.wallet.model.repository.datasource;

import com.hakim.wallet.cache.CardCache;
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
 *  Summary  :  本地的卡片数据缓存
 *
 */

@Singleton
public class LocalCardStore implements CardStore {

    private final CardCache cardCache;

    @Inject
    public LocalCardStore(CardCache cache){
        cardCache = cache;
    }

    @Override
    public void putCard(Card card) {
        cardCache.insertOrUpdate(card);
    }

    /**
     * 卡片信息及消费记录
     *
     * @param cardId
     */
    @Override
    public Observable<Card> cardDetail(String cardId) {
        return cardCache.card(cardId);
    }

    @Override
    public Observable<List<Card>> cardList(String cardType) {
        return cardCache.cardList(cardType);
    }
}
