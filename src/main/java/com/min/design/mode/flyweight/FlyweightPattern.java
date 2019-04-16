package com.min.design.mode.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 使用享元模式对象可以有效地支持大量的细粒度对象
 *
 * 具有四个角色
 * 1.抽象享元
 * 2.具体享元
 * 3.享元工厂
 * 4.客户端
 *
 * 优点：
 *  1.减少内存中对象的存在数量，提高性能
 *
 */
public class FlyweightPattern {
    //抽象享元
    interface Flyweight {
        //业务方法
        void operation(String extrinsicState);
    }

    //具体享元
    static class ConcreteFlyweight implements Flyweight {
        private String intrinsicState;//内部状态

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("内部状态：" + this.intrinsicState +
                    " 外部状态： " + extrinsicState
            );
        }
    }

    //享元工厂
    static class FlyweightFactory{
        private static Map<String, Flyweight> pool = new HashMap<>();
        private FlyweightFactory() {}
        public static Flyweight getFlyweight(String intrinsicState){
            Flyweight flyweight = pool.get(intrinsicState);
            if(flyweight == null){
                flyweight = new ConcreteFlyweight(intrinsicState);
                pool.put(intrinsicState, flyweight);
            }
            return flyweight;
        }
    }

}
