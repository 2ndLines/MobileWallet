package com.hakim.wallet.injector.module;

import android.database.sqlite.SQLiteOpenHelper;

import com.hakim.wallet.WalletApplication;
import com.hakim.wallet.cache.CardCache;
import com.hakim.wallet.cache.CardCacheImpl;
import com.hakim.wallet.cache.db.DbOpenHelper;
import com.hakim.wallet.model.repository.CardRepository;
import com.hakim.wallet.model.repository.CardRepositoryImpl;
import com.hakim.wallet.model.repository.SmallChangeRepository;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */

@Module
public class AppModule {
    private final WalletApplication application;

    public AppModule(WalletApplication application){
        this.application = application;
    }

    @Provides @Singleton
    WalletApplication provideApplication(){
        return application;
    }

    @Provides @Singleton
    CardRepository provideCardRepository(CardRepositoryImpl repository){
        return repository;
    }

    @Provides @Singleton
    CardCache provideCardCache(CardCacheImpl cardCache){
        return cardCache;
    }

    @Provides @Singleton
    SQLiteOpenHelper provideDbOpenHelper(WalletApplication application){
        return new DbOpenHelper(application);
    }

    @Provides @Singleton
    SqlBrite provideSqlBrite(){
        return SqlBrite.create();
    }

    @Provides @Singleton
    BriteDatabase provideBriteDataBase(SqlBrite sqlBrite, SQLiteOpenHelper sqLiteOpenHelper){
        return sqlBrite.wrapDatabaseHelper(sqLiteOpenHelper);
    }
}
