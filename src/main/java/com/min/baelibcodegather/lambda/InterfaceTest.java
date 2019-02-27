package com.min.baelibcodegather.lambda;

@FunctionalInterface
public interface InterfaceTest {

    void Test();

    //默认方法
    default void print() {
        System.out.println("....");
    }

    //静态方法
    static void blowHorn() {
        System.out.println("....");
    }

}
