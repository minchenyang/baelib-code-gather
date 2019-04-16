package com.min.design.mode.signle;

/**
 * 单例设计模式
 */
public class SinglePattern {

}

class SimpleSingle{
    private SimpleSingle(){}
    private static SimpleSingle simpleSingle = new SimpleSingle();
    public static SimpleSingle getSimpleSingle(){
        return simpleSingle;
    }
}
