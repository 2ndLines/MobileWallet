package com.hakim.wallet.cache;

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
public interface PrefsCache {

    boolean isCached(String key);

    void put(String key, String value);

    Observable<String> get(String key);

    boolean isExpired(String key);

    void delete(String key);

    void clear();


}
