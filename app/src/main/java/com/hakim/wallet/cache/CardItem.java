package com.hakim.wallet.cache;

import android.content.ContentValues;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public class CardItem {
    public static final String TABLE = "card_item";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String NO = "number";
    public static final String BALANCE = "balance";
    public static final String LOGO = "logo";

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder name(String name) {
            values.put(NAME, name);
            return this;
        }

        public Builder type(String type) {
            values.put(TYPE, type);
            return this;
        }

        public Builder no(String number) {
            values.put(NO, number);
            return this;
        }

        public Builder balance(String balance) {
            values.put(BALANCE, balance);
            return this;
        }

        public Builder logo(long logoId) {
            values.put(LOGO, logoId);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }

}
