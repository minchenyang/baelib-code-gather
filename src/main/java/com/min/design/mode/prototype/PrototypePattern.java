package com.min.design.mode.prototype;

/**
 * 原型模式
 * 1.客户角色
 * 2.抽象原型
 * 3.具体原型
 */
public class PrototypePattern {

    //抽象原型
    interface Protptype extends Cloneable{
        Protptype clone();
    }

    //具体原型
    class ConcreteProtetype implements Protptype{

        @Override
        public Protptype clone() {
            try {
                return (Protptype)super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    //客户角色
    class Client{
        public void operation(Protptype protptype){
            //得到副本
            protptype.clone();
        }
    }
}
