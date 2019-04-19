package com.min.design.mode.behavioral.visitor;

import java.util.Vector;

/**
 * 访问者模式
 * 封装一些作用与某种数据结构中各个元素的操作，它可以在不改变数据结构的前提下
 * 作用与这些元素的新操作。
 *
 *
 * 优点：
 * 1.访问者模式使得增加新的操作变的容易，增加新的操作只需要增加新的访问者类
 * 2.访问者将有关的行为集中到一个访问对象中，而不是分散到一个个元素类中
 *
 * <p>
 * 涉及5个角色：
 * 1.抽象访问者
 * 2.具体访问者
 * 3.抽象元素
 * 4.具体元素
 * 5.结构对象
 */
public class VisitorPattern {
    //抽象元素
    abstract class Element {
        //接受操作
        public abstract void accept(Visitor vi);
    }

    //具体元素1
    class ConcreteElement1 extends Element {

        @Override
        public void accept(Visitor vi) {
            vi.visit(this);
        }

        //业务逻辑方法
        public void operation() {
            System.out.println("访问元素1");
        }
    }

    //具体元素2
    class ConcreteElement2 extends Element {

        @Override
        public void accept(Visitor vi) {
            vi.visit(this);
        }

        //业务逻辑方法
        public void operation() {
            System.out.println("访问元素2");
        }
    }

    //抽象访问者
    interface Visitor {
        //可以访问哪些对象
        void visit(ConcreteElement1 e);

        void visit(ConcreteElement2 e);
    }

    //具体访问者
    static class ConcreteVisitor implements Visitor {
        //访问元素1
        @Override
        public void visit(ConcreteElement1 e) {
            e.operation();
        }

        //访问元素2
        @Override
        public void visit(ConcreteElement2 e) {
            e.operation();
        }
    }

    //结构对象
    static class ObjectStructure {
        private Vector<Element> elements = new Vector<>();

        //执行访问操作
        public void action(Visitor vi) {
            for (Element e : elements) {
                e.accept(vi);
            }
        }

        //添加新元素
        public void add(Element e) {
            elements.add(e);
        }

    }

    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //生成元素
        //创建一个访问者对象
        ConcreteVisitor visitor = new ConcreteVisitor();
        //访问者对结构进行访问
        os.action(visitor);
    }
}
