package com.min.design.mode.behavioral.observer;

import java.util.Vector;

/**
 * 观察者模式
 * 定义对象之间一种1对多的依赖关系，使得每当一个对象改变状态，所有依赖它的对象都会得到通知并被自动更新。
 *
 * <p>
 * 涉及4个角色：
 * 1.抽象主题
 * 2.抽象观察者
 * 3.具体主题
 * 4.具体观察者
 */
public class ObserverPattern {
    //抽象主题
    interface Subject {
        //登记一个新的观察者
        void attach(Observer obs);

        //删除一个登记过的观察者
        void detach(Observer obs);

        //通知观察者
        void notifyObserver();
    }

    //抽象观察者
    interface Observer {
        void update();
    }

    //具体主题
    class ConcreteSubject implements Subject {
        private Vector<Observer> observers = new Vector<>();
        @Override
        public void attach(Observer obs) {
            this.observers.add(obs);
        }

        @Override
        public void detach(Observer obs) {
            this.observers.remove(obs);
        }

        @Override
        public void notifyObserver() {
            observers.forEach(Observer::update);
        }
    }

    //具体观察者
    class ConcreteObserver implements Observer{

        @Override
        public void update() {
            System.out.println("收到通知：处理具体逻辑");
        }
    }
}
