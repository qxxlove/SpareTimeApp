package com.tjbool.httpwww.sparetimeapp.lambda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.DynamicEntity;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

/**
 * description:
 * autour: TMM
 * date: 2018/2/2 15:57
 * update: 2018/2/2
 * version:
 *    Lambda 表达式的基本写法：  1.2.3.4.5.6.7
 *   方法的引用（直接引用存在的方法）：8.9
 *   构造器引用： 其实和方法引用十分相似，只不过方法名替换为 new 。
 *               其格式为 ClassName :: new。这时编译器会通过上下文判断传入的参数的类型、顺序、数量等，来调用适合的构造器，返回对象。
 *
 *    使用技巧（快捷键）： 如果我们配置了Java_8即Lambda表达式，
 *                         在我们常规的写法，会变灰，提示我们使用Lambda表达式，as快捷键“Alt + enter”
 *                           第一项 （Replace with lambda）： 表达式的写法
 *                           第二项（Gradle files have changed since last project sy...）:   方法的引用和构造器的引用。
 *    在Lambda常量的使用  ： 10
 *
 *     补充：
 *           this 关键字
            在匿名内部类中，this 关键字指向的是匿名类本身的对象，而在 lambda 中，this 指向的是 lambda 表达式的外部类。
            方法数量差异
            当前 Android Studio 对 Java 8 新特性编译时采用脱糖（desugar）处理，
            lambda 表达式经过编译器编译后，每一个 lambda 表达式都会增加 1~2 个方法数。而 Android 应用的方法数不能超过 65536 个。
            虽然一般应用较难触发，但仍需注意。
*/

public class LambdaUseActivity extends AppCompatActivity {

     // 成员变量
    private  int  age = 10000;


    interface  Comparator<T> {
        int compare(T A, T B);
    }

    /**
     * 1.我们一般使用的写法
     */
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String A, String B) {
            doSomeThing();
            return 0;
        }
    };

    /**
     * 2.Lambda 表达式使用
     */
    Comparator<String>  comparator1 = (String a, String b) -> {
        doSomeThing();
        return 0;
    };

    /**
     * 3.当编译器可以推导出具体的参数类型时，我们可以从参数列表中忽略参数类型，那么上面的代码就变成了：
     */
    Comparator<String>  comparator2 = ( a,  b) -> {
        doSomeThing();
        return 0;
    };

    /**
     * 4.当参数只有一个时，参数列表两侧的圆括号也可省略
     */

    interface  OnClickListener { void click(View v);}
     OnClickListener  onClickListener = v -> { doSomeThing();};

    /**
     * 5.当方法没有传入参数的时候，则记得提供一对空括号假装自己是参数列表（雾），比如 Runnable 接口：
     */
    interface  MRunnable  { void  run();}
    MRunnable mRunnable = () -> {doSomeThing();};


    /**
     * 7.当只有一句去除花括号的表达式且接口方法需要返回值时，这个表达式不用（也不能）在表达式前加 return ，就可以当作返回语句。下面用 Java 的 Function 接口作为示例，这是一个用于转换类型的接口
     * @param <T>
     * @param <A>
     */
    interface  Function<T,A>  { A apply (T t);}
    Function<DynamicEntity,String> function = new Function<DynamicEntity, String>() {
        @Override
        public String apply(DynamicEntity dynamicEntity) {
            return dynamicEntity.getContent();
        }
    };

    Function<DynamicEntity,String> function1 = dynamicEntity -> dynamicEntity.getContent();


    /**
     * 8. 当我们使用第一种 lambda 表达式的时候，进行逻辑实现的时候我们既可以自己实现一系列处理，也可以直接调用已经存在的方法，
     *   下面以 Java 的 Predicate 接口作为示例，此接口用来实现判断功能，我们来对字符串进行全面的判空操作：
     */
    interface  Predicate<T> { boolean test(T t) ; }
     Predicate<String>  predicate = new Predicate<String>() {
         @Override
         public boolean test(String s) {
             // 用我们常见的逻辑去判断
             return s.length() == 0 || s==null;
         }
     };

    //TextUtils 的 isEmpty() 方法实现了上述功能
    Predicate<String> predicate1= s -> TextUtils.isEmpty(s);

    //使用方法引用之后的写法
    Predicate<String> predicate2= TextUtils :: isEmpty;

    /**
     * 9 方法应用的常见三种形式
     *    object :: instanceMethod
     *    说明： 直接调用任意对象的实例方法，如 obj::equals 代表调用 obj 的 equals 方法与接口方法参数比较是否相等，效果等同 obj.equals(t);。
     *           当前类的方法可用this::method进行调用，父类方法同理。
     *
     *    ClassName :: staticMethod
     *    说明：直接调用某类的静态方法，并将接口方法参数传入，如上述 TextUtils::isEmpty，效果等同 TextUtils.isEmpty(s);
     *
           ClassName :: instanceMethod
          说明：较为特殊,将接口方法参数列表的第一个参数作为方法调用者，其余参数作为方法参数。
          由于此类接口较少，故选择 Java 提供的 BiFunction 接口作为示例，
          该接口方法接收一个 T1 类对象和一个 T2 类对象，通过处理后返回 R 类对象：

     */

     interface  bigFunction<T1,T2,B> {
               B isEqueal(T1 t1,T2 t2);
    }
     bigFunction<String,String,Boolean> bigFunction = new bigFunction<String, String, Boolean>() {
         @Override
         public Boolean isEqueal(String s, String s2) {
             return s.equals(s2);
         }
     };

    bigFunction<String,String,Boolean> bigFunction1 = String :: equals;



    /**                                                          s
     * 做一些逻辑处理
     */
    private void doSomeThing() {


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda_use);
        initView();

    }

    private void initView() {
        /**
         * 6.当语句块内的处理逻辑只有一句表达式时，其两侧的花括号也可省略，特别注意这句处理逻辑表达式后面也不带分号。
         * 比如这个关闭 activity 的点击方法
         */
        findViewById(R.id.text_click_one).setOnClickListener(v -> LambdaUseActivity.this.finish());

        /**
         *   10 去掉①②③ 任何一个注释都会报错，自行测试
         */
        //①private  int  age = 10000;
        findViewById(R.id.text_click_two).setOnClickListener(view -> {
            ToastUtils.showShortToast(age+"");
            //②private  int  age = 10000;
        });
        //③private  int  age = 10000;
    }
}
