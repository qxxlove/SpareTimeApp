package com.tjbool.httpwww.sparetimeapp.entity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/5/10.
 * 邮箱：123123@163.com
 */

public class SingleMutileBean extends  BaseEntity {

    private  String  content ;
    private  boolean isChcek = false;


    public SingleMutileBean(String content) {
        this.content = content;
      
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
