package com.hakim.wallet.domain;

import com.hakim.wallet.model.repository.SmallChangeRepository;

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
public class SmallChangeUserCase implements UserCase<String> {
    private final SmallChangeRepository repository;

    @Inject
    public SmallChangeUserCase(SmallChangeRepository repository){
        this.repository = repository;
    }

    @Override
    public Observable<String> execute(String key) {
        return repository.getAmount();
    }
}
