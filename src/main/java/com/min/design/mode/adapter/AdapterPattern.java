package com.min.design.mode.adapter;

/**
 * 适配器模式
 * 将一个类或者接口转换成其他的类或者接口
 *
 * 优点：
 *  让两个没有任何关系的类在一起运行
 *      增加类的透明性
 *      提高类的复用性
 *      增强代码的灵活性
 *
 * 涉及三个角色
 * 1.目标角色
 * 2.源角色
 * 3.适配器角色
 */
public class AdapterPattern {
    //源角色
    class Adoptee {
        public void specificRequest(){}
    }

    //目标角色
    interface Target{
        void request();
    }

    //适配器角色
    //将Adoptee 实现了 Target 接口
    class Adapter extends Adoptee implements Target{

        @Override
        public void request() {
            super.specificRequest();
        }
    }
}
