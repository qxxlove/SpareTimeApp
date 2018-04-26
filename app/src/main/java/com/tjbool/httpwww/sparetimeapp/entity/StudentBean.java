package com.tjbool.httpwww.sparetimeapp.entity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/17.
 * 邮箱：123123@163.com
 */

public class StudentBean extends   BaseEntity {


    private  int   sId;
    private String name ;


    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentBean(int sId, String name) {
        this.sId = sId;
        this.name = name;
    }
}
