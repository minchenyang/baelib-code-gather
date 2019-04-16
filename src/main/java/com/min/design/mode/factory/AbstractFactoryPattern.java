package com.min.design.mode.factory;

/**
 * 抽象工厂模式
 * 1.抽象工厂
 * 2.具体工厂
 * 3.抽象产品
 * 4.具体产品
 */
public class AbstractFactoryPattern {

    //抽象工厂
    interface AbstractFactory{
        Product factoryA();
        Product factoryB();
    }

    //具体工厂1
    class AbstractFactory1 implements AbstractFactory{

        @Override
        public Product factoryA() {
            return new ProductA1();
        }

        @Override
        public Product factoryB() {
            return new ProductB1();
        }
    }

    class AbstractFactory2 implements AbstractFactory{

        @Override
        public Product factoryA() {
            return new ProductA2();
        }

        @Override
        public Product factoryB() {
            return new ProductB2();
        }
    }

    //产品抽象
    interface Product{
        void method();
    }

    //产品类A1
    class ProductA1 implements Product{
        @Override
        public void method() {

        }
    }
    //产品类A2
    class ProductA2 implements Product{
        @Override
        public void method() {

        }
    }

    //产品类B1
    class ProductB1 implements Product{
        @Override
        public void method() {

        }
    }
    //产品类B2
    class ProductB2 implements Product{
        @Override
        public void method() {

        }
    }
}
