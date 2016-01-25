package com.hakim.wallet.cache;

import android.content.ContentValues;
import android.database.Cursor;

import com.hakim.wallet.model.entities.Card;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 *
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */

@Singleton
public class CardCacheImpl implements CardCache {
    private static final String CARD_QUERY = ""
            + " select * from "
            + CardItem.TABLE
            + " where "
            + CardItem.NO
            + " = ?";

    private static final String CARD_LIST = ""
            + " select * from "
            + CardItem.TABLE
            + " where "
            + CardItem.TYPE
            + " = ?";

    private static final String CARD_COUNT = ""
            + "select count(*) from "
            + CardItem.TABLE
            + " where "
            + CardItem.TYPE
            + " = ?";

    private final BriteDatabase db;

    @Inject
    public CardCacheImpl(BriteDatabase db) {
        if (db == null) {
            throw new IllegalArgumentException("Constructor parameter can not be null");
        }

        this.db = db;
    }

    @Override
    public Observable<Card> card(final String cardId) {
        return db.createQuery(CardItem.TABLE, CARD_QUERY)
                .mapToOne(Card.MAPPER);
    }

    @Override
    public Observable<List<Card>> cardList(String cardType) {
        return db.createQuery(CardItem.TABLE, CARD_LIST)
                .mapToList(Card.MAPPER);
    }

    @Override
    public Observable<Boolean> isCached(String key) {
        return db.createQuery(CardItem.TABLE, CARD_COUNT)
                .map(new Func1<SqlBrite.Query, Boolean>() {
                    @Override
                    public Boolean call(SqlBrite.Query query) {

                        Cursor cursor = query.run();
                        try{
                            return cursor.moveToNext() && cursor.getInt(0) > 0;
                        }finally {
                            cursor.close();
                        }
                    }
                });
    }


    @Override
    public void insertOrUpdate(Card card) {
        ContentValues values = new CardItem.Builder()
                .name(card.name())
                .type(card.type())
                .no(card.no())
                .balance(card.balance())
                .logo(card.logo())
                .build();

        db.insert(CardItem.TABLE, values);
    }

    @Override
    public void delete() {

    }
}
