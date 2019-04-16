package com.min.design.mode.behavioral.strategy;

/**
 * 策略模式
 * 定义一组算法，将每个算法都封装起来，并使它们之间可以互相转换。
 *
 * <p>
 * 涉及三个角色：
 * 1.环境角色 (起到承上启下的作用)
 * 2.抽象策略
 * 3.具体策略
 */
public class StrategyPattern {

    //抽象策略
    abstract class Strategy {
        public abstract void strategyInterface();
    }

    //具体策略
    class ConcreteStrategy extends Strategy {
        //实现策略方法
        @Override
        public void strategyInterface() {
            //具体算法
        }
    }

    //环境角色
    class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        //调用策略方法
        public void contextInterface() {
            this.strategy.strategyInterface();
        }
    }

}
