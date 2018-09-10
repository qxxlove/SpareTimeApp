package com.tjbool.httpwww.sparetimeapp.utils.screen;


/**
 * description:
 * autour: TMM
 * date: 2018/8/24 17:44
 * update: 2018/8/24
 * version:
 *
 *
 *
*/


public class DimenGenerator {

    /**
     * 设计稿尺寸(根据自己设计师的设计稿的宽度填入)
     */
    private static final int DESIGN_WIDTH = 375;

    /**
     * 设计稿高度  没用到
     */
    private static final int DESIGN_HEIGHT = 667;

    public static void main(String[] args) {

        DimenTypes[] values = DimenTypes.values();
        for (DimenTypes value : values) {
            MakeUtils.makeAll(DESIGN_WIDTH, value, "/androidui/adapter");
        }
       System.out.print("Hello woold");

    }

}

/**
 *
 * AS 运行 main函数报错
 * Error:Gradle: A problem occurred configuring root project 'SpareTimeApp'.
 > Could not resolve all files for configuration ':classpath'.
 > Could not find com.android.tools.build:gradle:3.0.1.
 Searched in the following locations:
 https://jcenter.bintray.com/com/android/tools/build/gradle/3.0.1/gradle-3.0.1.pom
 https://jcenter.bintray.com/com/android/tools/build/gradle/3.0.1/gradle-3.0.1.jar
 Required by:
 project :

 解决： 运行main 函数报错
 https://blog.csdn.net/LLJJYY001/article/details/78805421

 *
 */

