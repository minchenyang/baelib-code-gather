package com.min.design.mode.builder;

/**
 * 建造者设计模式
 * 1.抽象建造者
 * 2.具体建造者
 * 3.产品角色
 * 4.导演者角色
 */
public class BuilderPattern {

    //产品角色
    class Product{
    }

    //抽象建造者
    abstract class Builder{
        //设置产品的不同的部分，获得不同的产品
        abstract void setPart1();
        abstract void setPart2();
        abstract void setPart3();
        abstract Product builderProduct();
    }

    //具体建造者
    class ConcreteBuilder extends Builder{
        Product product = new Product();
        @Override
        void setPart1() {
            //安装部件
        }

        @Override
        void setPart2() {
            //安装部件
        }

        @Override
        void setPart3() {
            //安装部件
        }

        @Override
        Product builderProduct() {
            return product;
        }
    }

    //导演者
    class Director{
        private Builder builder = new ConcreteBuilder();
        public Product build(){
            builder.setPart1();
            builder.setPart2();
            builder.setPart3();
            return builder.builderProduct();
        }
    }
}
