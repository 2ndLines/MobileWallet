package com.hakim.wallet.mvp.views;

import com.hakim.wallet.model.entities.Card;

import java.util.List;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/22
 *
 *  Summary  :
 *
 */
public interface CardView extends MvpView{

    void listCard(List<Card> cards);

    void cardDetail(Card card);

}
