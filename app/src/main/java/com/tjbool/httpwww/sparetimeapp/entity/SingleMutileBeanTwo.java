package com.tjbool.httpwww.sparetimeapp.entity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/5/10.
 * 邮箱：123123@163.com
 */

public class SingleMutileBeanTwo extends  BaseEntity {

    private  String  content ;
    private  boolean isChcek;

    public SingleMutileBeanTwo(String content, boolean isChcek) {
        this.content = content;
        this.isChcek = isChcek;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChcek() {
        return isChcek;
    }

    public void setChcek(boolean chcek) {
        isChcek = chcek;
    }
}
