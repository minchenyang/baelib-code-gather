package com.min.design.mode.facade;

/**
 * 外观模式
 * 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行
 *
 * 外观模式具有两个角色：
 * 1.外观角色
 * 2.子系统角色
 *
 * 优点：
 *  1.减少子系统的互相依赖。
 *  2.提供灵活性，不管子系统如何变换，子要不影响Facade任何活动都是自由的
 *  3.提高安全性Facade未提供方法，外界就无法访问
 */
public class FacadePattern {

    //外观角色
    class Facade{
        //被委托的对象
        private ClassA a = new ClassA();
        private ClassB b = new ClassB();
        private ClassC c = new ClassC();

        public void methodA(){this.a.methodA();}
        public void methodB(){this.b.methodB();}
        public void methodC(){this.c.methodC();}
    }


    //子系统角色
    class ClassA{
        void methodA(){};
    }
    class ClassB{
        void methodB(){};
    }
    class ClassC{
        void methodC(){};
    }
}
