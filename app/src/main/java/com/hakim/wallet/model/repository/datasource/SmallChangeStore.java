package com.hakim.wallet.model.repository.datasource;

import rx.Observable;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
public class SmallChangeStore {

    public SmallChangeStore(){
        //Empty constructor
    }

    public Observable<String> getAmount(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Observable.just("110.112");
    }
}
