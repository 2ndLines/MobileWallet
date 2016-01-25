package com.hakim.wallet.domain.exception;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/19
 *
 *  Summary  :
 *
 */
public class CardNotFoundException extends Exception {
    public CardNotFoundException() {
        super();
    }

    public CardNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public CardNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CardNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
