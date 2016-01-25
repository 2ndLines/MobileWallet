package com.hakim.wallet.cache.db;

import android.database.Cursor;

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
public final class Db {

    private static final int BOOLEAN_FALSE = 0;
    private static final int BOOLEAN_TRUE = 1;

    public static String getString(Cursor cursor, String columnName){
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }

    public static boolean getBoolean(Cursor cursor, String columnName){
        return getInt(cursor, columnName) == BOOLEAN_TRUE;
    }

    public static int getInt(Cursor cursor, String columnName){
        return cursor.getColumnIndexOrThrow(columnName);
    }

    public static long getLong(Cursor cursor, String columnName){
        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }

    private Db(){
        throw new AssertionError("No instance");
    }
}
