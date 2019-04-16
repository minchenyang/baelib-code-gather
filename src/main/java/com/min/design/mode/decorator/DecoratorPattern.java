package com.min.design.mode.decorator;

/**
 * 装饰设计模式
 * 动态的给一个对象添加一些额外的职责，
 * 就增加功能来说 比生成子类更加灵活
 *
 * 使用场景：
 *      1.需要拓展一个类的功能，或者给一个类附加功能
 *      2.在一些情况下 使用集成会增加很多子类，而且灵活性差，装饰模式可以代替继承，解决类膨胀问题
 *
 *
 * 4个角色
 * 1.抽象构件
 * 2.具体构件
 * 3.装饰角色
 * 4.具体角色
 */
public class DecoratorPattern {
    //抽象构件
    interface Component {
        void operation();
    }

    //具体构件
    class ConcreteComponent implements Component {
        @Override
        public void operation() {

        }
    }

    //装饰角色
    abstract class Decorator implements Component {
        private Component component = null;

        public Decorator(Component component) {
            this.component = component;
        }

        public void operation(){
            this.component.operation();
        }
    }

    //具体角色
    public class ConcreteDecorator extends Decorator{
        private Component component;
        public ConcreteDecorator(Component component) {
            super(component);
        }
        //定义自己的方法
        private void method(){}
        //重写operation方法
        public void operation(){
            this.method();
            super.operation();
        }
    }
}
