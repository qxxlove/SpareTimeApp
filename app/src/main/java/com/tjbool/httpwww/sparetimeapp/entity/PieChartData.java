package com.tjbool.httpwww.sparetimeapp.entity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/12/12.
 * 邮箱：123123@163.com
 */

public class PieChartData  {


    /**用户关心的数据，即你的自定义view要展示的参数*/
    private String name;        // 名字
    private float value;        // 数值
    private float percentage;   // 百分比


    /**非用户关心数据，即我们实现所需要的辅助参数*/
    private int color = 0;      // 颜色
    private float angle = 0;    // 角度

    public PieChartData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public PieChartData(String name, float value, float percentage) {
        this.name = name;
        this.value = value;
        this.percentage = percentage;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
