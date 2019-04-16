package com.min.design.mode.proxy;

/**
 * 静态代理
 */
public class StaticProxyPattern {

    //抽象主题
    interface Subject{
        //定义一个请求方法
        void request();
    }

    //代理主题
    class ProxySubject implements Subject{
        private Subject subject;

        public ProxySubject(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            this.beforeRequest();
            subject.request();
            this.afterRequest();
        }
        //预处理
        private void beforeRequest(){}
        //请求后处理
        private void afterRequest(){}
    }

    //真实主题
    class RealSubject implements Subject{

        @Override
        public void request() {
            //业务逻辑
        }
    }
}
