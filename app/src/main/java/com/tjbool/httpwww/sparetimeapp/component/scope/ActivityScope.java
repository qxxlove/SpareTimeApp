package com.tjbool.httpwww.sparetimeapp.component.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * description: 自定义Scope注解
 * autour: TMM
 * date: 2018/4/26 9:35
 * update: 2018/4/26
 * version:
*/


@Scope  //声明这是一个自定义@Scope注解
@Retention(RUNTIME)
public @interface ActivityScope {
    
}
