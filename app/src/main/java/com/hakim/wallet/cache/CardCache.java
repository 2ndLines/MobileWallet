package com.hakim.wallet.cache;

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
public interface CardCache {
    /**
     * 获取一个将发射Card数据的Observable对象，
     *
     * @param cardId 卡片id
     */
    Observable<Card> card(String cardId);

    Observable<List<Card>> cardList(String cardType);

    Observable<Boolean> isCached(String key);

    /**
     * 插入数据
     *
     * @param card 数据对象
     */
    void insertOrUpdate(Card card);

    /**
     * 删除卡片数据
     */
    void delete();
}
