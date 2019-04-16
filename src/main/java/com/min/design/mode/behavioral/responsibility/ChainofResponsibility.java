package com.min.design.mode.behavioral.responsibility;

import lombok.Data;

/**
 * 责任链模式
 * 使多个对象都有机会处理请求，从而避免请求的发送和接收之间的耦合，将这些对象
 * 连成一条链，并沿着这条链传递该请求，直到有对象处理它。
 * <p>
 * 优点：
 * 1.请求和处理分开。请求者不知道是谁处理的。处理者不用知道请求的全貌。
 * 2.提高系统灵活性
 * 缺点：
 * 1.降低程序性能。
 * 2.不利于调试。
 *
 * <p>
 * 涉及两个角色：
 * 1.抽象处理者
 * 2.具体处理者
 */
public class ChainofResponsibility {

    //抽象处理者
    @Data
    static abstract class Handler {
        private Handler successor;

        //处理方法
        public abstract void handleRequest();
    }

    //具体处理者
    static class ConcreteHandler extends Handler {
        @Override
        public void handleRequest() {
            if (getSuccessor() != null) {
                System.out.println("请求传递给：" + getSuccessor());
                getSuccessor().handleRequest();
            } else {
                System.out.println("请求处理");
            }
        }
    }

    public static void main(String[] args) {
        ConcreteHandler concreteHandler1 = new ConcreteHandler();
        ConcreteHandler concreteHandler2 = new ConcreteHandler();
        concreteHandler1.setSuccessor(concreteHandler2);
        concreteHandler1.handleRequest();
    }
}
