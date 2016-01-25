package com.hakim.wallet.model.entities;

import android.database.Cursor;

import com.hakim.wallet.cache.CardItem;
import com.hakim.wallet.cache.db.Db;

import auto.parcel.AutoParcel;
import rx.functions.Func1;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  : 卡片实体类
 *
 */

@AutoParcel
public abstract class Card {

    /**
     * 卡片名称
     */
    public abstract String name();

    /**
     * 卡片类型
     *
     * @see CardType
     */
    public abstract String type();

    /**
     * 卡片余额
     */
    public abstract String balance();

    /**
     * 卡号
     */
    public abstract String no();

    /**
     * 卡片LOGO
     */
    public abstract long logo();

    public static final Func1<Cursor, Card> MAPPER = new Func1<Cursor, Card>() {
        @Override
        public Card call(Cursor cursor) {
            String name = Db.getString(cursor, CardItem.NAME);
            String type = Db.getString(cursor, CardItem.TYPE);
            String number = Db.getString(cursor, CardItem.NO);
            String balance = Db.getString(cursor, CardItem.BALANCE);
            long logo = Db.getLong(cursor, CardItem.LOGO);
            return new AutoParcel_Card(name, type, number, balance, logo);
        }
    };

}
