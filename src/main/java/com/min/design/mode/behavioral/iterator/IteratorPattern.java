package com.min.design.mode.behavioral.iterator;

import java.util.Vector;

/**
 * 迭代器模式
 * 提供一种方法访问一个容器对象中各个元素，而又不暴露对象内部的细节。
 *
 * 迭代器模式涉及4个角色：
 * 1.抽象迭代器角色 (定义访问和遍历元素的接口)
 * 2.具体迭代器角色 (实现Iterator接口，完成元素遍历)
 * 3.抽象聚合(提供创建迭代器的接口)
 * 4.具体聚合 （创建出容纳迭代器的对象）
 */
public class IteratorPattern {

    //抽象迭代器角色
    interface Iterator{
        Object next();
        boolean hasNext();
    }
    //具体迭代器角色
    class ConcreteIterator implements Iterator{
        private ConcreteAggregate agg;
        private int index;
        private int size;

        public ConcreteIterator(ConcreteAggregate agg) {
            this.agg = agg;
            this.index = 0;
            this.size = agg.size();
        }

        @Override
        public Object next() {
            if(index < size)
                return agg.getElement(index);
            else
                return null;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }
    }
    //抽象聚合
    interface Aggregate{
        void add(Object obj);
        Iterator createIterator();
    }

    //具体聚合
    class ConcreteAggregate implements Aggregate{
        private Vector vector = new Vector();
        public void add(Object obj){
            this.vector.add(obj);
        }
        public Object getElement(int index){
            if(index < vector.size()){
                return vector.get(index);
            }else
                return null;
        }
        public int size (){
            return this.vector.size();
        }
        public Iterator createIterator(){
            return new ConcreteIterator(this);
        }
    }

    public void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();
        agg.add("1");
        agg.add("2");
        agg.add("3");
        //遍历
        Iterator iterator = agg.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
