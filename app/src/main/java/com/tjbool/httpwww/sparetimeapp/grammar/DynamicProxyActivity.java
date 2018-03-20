package com.tjbool.httpwww.sparetimeapp.grammar;

import android.content.Intent;
import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/** 
 * description: 动态代理
 * autour: TMM
 * date: 2018/3/2 10:26 
 * update: 2018/3/2
 * version:
 *
 *  参考链接：  http://mp.weixin.qq.com/s/AiZqQjXdkK0k0gekiBIVFg
*/


public class DynamicProxyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_proxy);
        initProxy();
    }

    /**
     * 最简单的动态代理
     * 原理：我们写了一个接口，就能产生一个该接口的对象，然后我们还能拦截它的方法。
     *       我们自定义IUserService 接口，产生该接口的对象，
     *       并拦截他的方法（触发机制：当我们调用login 方法的时候）
     *
     *       接下来：我们想到Retrofit的原理：
     *               其实就是这样，拦截到方法、参数，再根据我们在方法上的注解，去拼接为一个正常的Okhttp请求，然后执行。
     *
     */
    private void initProxy() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(),
                new Class[]{IUserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method = " + method.getName() +" , args = " + Arrays.toString(args));
                        return null;
                    }
                });
        System.out.println(userService.getClass());
        userService.login("zhy","123");

    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }
}
