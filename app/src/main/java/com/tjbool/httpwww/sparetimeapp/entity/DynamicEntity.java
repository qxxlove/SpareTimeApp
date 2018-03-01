package com.tjbool.httpwww.sparetimeapp.entity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/19.
 * 邮箱：123123@163.com
 */

public class DynamicEntity {

    private  String  content;
    private  String  image_url;


    public DynamicEntity(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
