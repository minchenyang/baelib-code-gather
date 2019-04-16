package com.min.design.mode.bridge;

/**
 * 桥梁设计模式
 *
 * 将抽象和实现解耦，使两者可以独立的变换
 *
 * //桥接模式有4个角色
 * 1.抽象化
 * 2.现实化
 * 3.修正抽象化
 * 4.具体实现化
 */
public class BridgePattern {

    //现实化
    interface Implmentor{
        //方法实现化声明
        void operationImpl();
    }

    //具体实现化1
    static class ConcreteImplementor1 implements Implmentor{
        //方法实现化
        @Override
        public void operationImpl() {}
    }

    //具体实现化2
    static class ConcreteImplementor2 implements Implmentor{
        //方法实现化
        @Override
        public void operationImpl() {}
    }

    //抽象化
    static abstract class Abstraction{
        //定义对实现化角色的引用
        private Implmentor impl;
        public Abstraction(Implmentor impl) { this.impl = impl;}
        //业务方法
        void operation(){
            this.impl.operationImpl();
        }
    }

    //修正抽象化
    static class RefinedAbstraction extends Abstraction{
        public RefinedAbstraction(Implmentor impl) {
            super(impl);
        }
        //修正方法
        void operation(){
            //业务代码
        }
    }

    public static void main(String[] args) {
        // 定义一个实现化角色
        Implmentor impl = new ConcreteImplementor1();
        // 定义一个抽象化角色
        Abstraction abstraction = new RefinedAbstraction(impl);
        //执行
        abstraction.operation();
    }
}

