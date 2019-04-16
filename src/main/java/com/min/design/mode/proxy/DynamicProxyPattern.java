package com.min.design.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * 动态代理通过反射类Proxy和InvocationHandler回调接口实现，要求委托类必须实现一个接口，只能对该类接口中定义的方法实现代理
 */
public class DynamicProxyPattern {

    //测试
    public static void main(String[] args) {
        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(new Object());
        subject.doSomething();
    }

}
//接口
interface Subject {
    void doSomething();
}

//被代理类
class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}

//代理类
class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
        Object result = method.invoke(target, args);
        System.out.println("Do something after");
        return result;
    }

}