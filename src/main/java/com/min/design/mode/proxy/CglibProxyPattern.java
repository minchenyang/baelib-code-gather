package com.min.design.mode.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 动态代理
 * 1.需要引入 cglib.jar   或直接引入spring 即可.
 * 2.代理类不能为final
 * 3.若目标对象的方法 为 final/static,那么就不会被拦截.即不会执行目标额外的业务方法.
 *
 *
 */
public class CglibProxyPattern {
    //生成代理
    public static void main(String[] args) throws IOException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserService userService = (UserService)enhancer.create();
        userService.delete(5);
    }
}

class UserService{
    public void add() {
        System.out.println("This is add service");
    }
    public void delete(int id) {
        System.out.println("This is delete service：delete " + id );
    }
}

//代理方法逻辑
class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:" + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After:" + method);
        return object;
    }
}

