package com.tjbool.httpwww.sparetimeapp.entity;

/** 
 * description: EventBus 错误处理实体类
 * autour: TMM
 * date: 2018/2/27 10:35 
 * update: 2018/2/27
 * version: 
*/

public class EventErrorDeal {
    
    private String method ;
    private String content;

    public EventErrorDeal(String method, String content) {
        this.method = method;
        this.content = content;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
