package com.tjbool.httpwww.androiddaggermvp.mvp.model;

import com.tjbool.httpwww.androiddaggermvp.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/26.
 * 邮箱：123123@163.com
 */

public class MainModel implements MainContract.Model {

    @Inject
    public MainModel() {
    }


    public  String  requestMessage (){
        return "ok";
    }

}
