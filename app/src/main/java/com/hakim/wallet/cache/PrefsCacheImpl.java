package com.hakim.wallet.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences.RxSharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Author   ：	Hakim Shi
 * Email    :  hakim.shi@qq.com
 * CreatedAt：	2016/1/21
 * <p/>
 * Summary  :
 */

@Singleton
public class PrefsCacheImpl implements PrefsCache {
    private final SharedPreferences prefs;
    private final RxSharedPreferences mRxPrefs;

    @Inject
    public PrefsCacheImpl(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        mRxPrefs = RxSharedPreferences.create(prefs);
    }

    @Override
    public boolean isCached(String key) {
        return prefs.contains(key);
    }

    @Override
    public void put(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    @Override
    public Observable<String> get(String key) {
        return mRxPrefs.getString(key, null).asObservable();
    }

    @Override
    public boolean isExpired(String key) {

        return false;
    }

    @Override
    public void delete(String key) {
        prefs.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        prefs.edit().clear().apply();
    }
}
