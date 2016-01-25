package com.hakim.wallet.injector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
