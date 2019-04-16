package com.min.design.mode.behavioral.template;

/**
 * 模板方法模式
 * 定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该
 * 算法的某些特定的步骤。
 *
 * 优点：
 * 1.封装不变的部分，拓展可变的部分。
 * 2.提取公共代码，便于维护。
 * 3.行为由父类控制，子类实现。
 *
 * 涉及2个角色：
 * 1.抽象模板角色
 * 2.集体模板角色
 */
public class TemplatePattern {

    //抽象模板角色
    static abstract class AbstractClass{
        //基本方法
        protected abstract void operation();
        //模板方法
        public void templateMethod(){
            //调用基本方法，完成相关逻辑
            this.operation();
        }
    }

    //具体模板角色
    static class ConcreteClass extends AbstractClass{

        @Override
        protected void operation() {
            //实现基本方法
        }
    }

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        //调用模板方法
        concreteClass.templateMethod();
    }
}
