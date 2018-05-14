package com.tjbool.httpwww.sparetimeapp.custom;

import android.animation.TypeEvaluator;

import com.tjbool.httpwww.sparetimeapp.entity.Point;

/**
 * description: 自定义圆的动画效果 估值器
 * autour: TMM
 * date: 2018/5/14 11:50 
 * update: 2018/5/14
 * version: 
*/

public class PointEvaluator implements TypeEvaluator {

  

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // 将动画初始值startValue 和 动画结束值endValue 强制类型转换成Point对象
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        // 根据fraction来计算当前动画的x和y的值
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());

        // 将计算后的坐标封装到一个新的Point对象中并返回
        Point point = new Point(x, y);
        
        return point;
    }
}
