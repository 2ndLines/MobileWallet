package com.hakim.wallet.model.repository;

import com.hakim.wallet.model.repository.datasource.SmallChangeStore;

import javax.inject.Inject;

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
public class SmallChangeRepository {
    private final SmallChangeStore dataStore;

    @Inject
    public SmallChangeRepository(){
        dataStore = new SmallChangeStore();
    }

    /**
     * 获取零钱金额
     */
    public Observable<String> getAmount(){
        return dataStore.getAmount();
    }
}
