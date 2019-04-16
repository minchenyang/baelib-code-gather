package com.min.design.mode.factory;

/**
 * 4个角色
 * 1.抽象工厂
 * 2.具体工厂
 * 3.抽象产品
 * 4.具体产品
 */
public class FactoryMethodPattern {

    //抽象工厂
    interface AbstractFactory {
        <T extends AbstractProduct> T factory(Class<T> c);
    }

    //具体工厂
    class SpecificFactory implements AbstractFactory {
        @Override
        public <T extends AbstractProduct> T factory(Class<T> c) {
            AbstractProduct abstractProduct = null;
            try {
                abstractProduct = (AbstractProduct) Class.forName(c.getName()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return (T)abstractProduct;
        }
    }

    //抽象产品
    interface AbstractProduct {
        void method1();

        void method2();
    }

    //具体产品
    class SpecificProduct implements AbstractProduct{
        @Override
        public void method1() {}
        @Override
        public void method2() {}
    }
}
