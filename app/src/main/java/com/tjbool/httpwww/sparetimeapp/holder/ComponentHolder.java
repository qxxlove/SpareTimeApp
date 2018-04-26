package com.tjbool.httpwww.sparetimeapp.holder;

import com.tjbool.httpwww.sparetimeapp.component.DaggerComponentApplication;

/**
 * description: Component帮助类
 * autour: TMM
 * date: 2018/4/25 16:29
 * update: 2018/4/25
 * version:
*/
public class ComponentHolder {

    private  static DaggerComponentApplication application;


    public static void setAppComponent(DaggerComponentApplication component) {
        application = component;
    }

    public static DaggerComponentApplication getAppComponent() {
        return application;
    }





}
