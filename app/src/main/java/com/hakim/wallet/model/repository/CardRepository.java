package com.hakim.wallet.model.repository;

import com.hakim.wallet.model.entities.Card;

import java.util.List;

import rx.Observable;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public interface CardRepository {

    /**
     * 获取单张卡片信息
     *
     * @param cardId 卡片ID
     * @return 返回卡片对象的数据流
     */
    Observable<Card> card(String cardId);

    /**
     * 获取某个类型的所有卡片
     *
     * @param cardType  卡片类型
     * @return  返回所有卡片的数据流
     */
    Observable<List<Card>> cardList(String cardType);

}
