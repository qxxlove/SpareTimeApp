package com.tjbool.httpwww.sparetimeapp.grammar;


/**
 * description: 枚举的学习
 * autour: TMM
 * date: 2018/3/2 10:17
 * update: 2018/3/2
 * version:
*/


public class EnumStudy {

    /**
     * 但是我们实际开发中并不提倡使用枚举（原因： 很占用内存）
     * 官方建议使用常量和support注解，搜索下intdef
     * ①可以理解为枚举是静态变量的集合（换句话说，也就是定义了几个静态变量）
     *  ②枚举还是一个单例（因为Enum 对 readObject 和 clone  方法都进行了实现）
     *    这一点不是很明白（先记住）
     */
    public  enum  Person {
        Teacher,
        Student,
        Doctor,
    }

    public  void  test (){

    }

}
