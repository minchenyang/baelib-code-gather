package com.min.design.mode.behavioral.mediator;

import lombok.Data;
import lombok.Getter;

/**
 * 中介者模式
 * 用一个中介对象（同事）封装一系列对象的交互。中介者使各个对象不需要显示的互相作用
 * 从而使其耦合松散，而且可以独立地改变他们之间的交互。
 *
 * 优点:
 *  1.减少类间的依赖，将原有的1对多的依赖变为1对1.
 *  2.避免同事之间过多耦合，同事只依赖与中介者
 *  3.
 *  4.
 *
 * <p>
 * 涉及四个角色：
 * 1.抽象中介者
 * 2.具体中介者
 * 3.抽象同事
 * 4.具体同事
 */
public class MediatorPattern {
    //抽象中介者
    abstract class Mediator {
        //中介者模式的业务逻辑方法
        abstract void colleagueChanged(Colleague c);
    }

    //具体中介者
    class ConcreteMediator extends Mediator {
        @Getter
        private ConcreteColleague1 c1;
        @Getter
        private ConcreteColleague2 c2;

        @Override
        void colleagueChanged(Colleague c) {
            this.c1.action();
            this.c2.action();
        }

        //工厂方方法创建同事对象
        public void createConcreteMediator() {
            c1 = new ConcreteColleague1(this);
            c2 = new ConcreteColleague2(this);
        }
    }

    //抽象同事
    @Data
    abstract class Colleague {
        private Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

        //抽象行动由子类实现
        public abstract void action();

        //业务方法，调用此方法改变内部状态
        public void change() {
            this.mediator.colleagueChanged(this);
        }
    }

    //具体同事1
    class ConcreteColleague1 extends Colleague {

        public ConcreteColleague1(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void action() {
            System.out.println("同事1的行动方法");
        }
    }

    //具体同事2
    class ConcreteColleague2 extends Colleague{

        public ConcreteColleague2(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void action() {
            System.out.println("同事2的行动方法");
        }
    }
}
