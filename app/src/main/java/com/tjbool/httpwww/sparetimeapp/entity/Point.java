package com.tjbool.httpwww.sparetimeapp.entity;

/** 
 * description: 圆的位置坐标
 * autour: TMM
 * date: 2018/5/14 11:49 
 * update: 2018/5/14
 * version: 
*/

public class Point extends  BaseEntity {

    private  float  x;
    private  float  y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
