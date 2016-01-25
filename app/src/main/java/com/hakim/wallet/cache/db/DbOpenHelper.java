package com.hakim.wallet.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hakim.wallet.cache.CardItem;

/**
 * <pre>
 *
 *  Oule Online
 *
 *  Qianhui telecom Co., Ltd.
 *  Copyright (C): 2015
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/20
 *
 *  Summary  :
 *
 * </pre>
 */
final public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "card.db";
    private static final int VERSION = 1;

    private static final String CREATE_CARD_TABLE = ""
            + "create table " + CardItem.TABLE + "("
            + CardItem.ID + " integer not null primary key,"
            + CardItem.NAME + " text not null,"
            + CardItem.TYPE + " text not null,"
            + CardItem.NO + " text not null,"
            + CardItem.BALANCE + " text,"
            + CardItem.LOGO + " integer default 0"
            + ")";



    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CARD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
