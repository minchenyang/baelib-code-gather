package com.min.baelibcodegather.lambda;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

/**
 * 以下是lambda表达式的重要特征:
 *                  可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。 (不要要参数类型)
 *                  可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。(不需要圆括号)
 *                  可选的大括号：如果主体包含了一个语句，就不需要使用大括号。(不需要大括号)
 *                  可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。(不需要return)
 *
 * 方法引用
 *          方法引用通过方法的名字来指向一个方法
 *          方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 *          方法引用使用一对冒号 ::
 */
public class Lambda {

    public static void main(String[] args) {
        //类型声明
        MathOperation addition = (int a, int b) -> a + b;
        //不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        /**
         * 方法引用
         * 静态方法引用
         * (X1, X2, X3,...) -> {X.methodName(X1, X2, X3,...)}
         * X::methodName
         *
         * 类成员方法引用
         * (X1, X2, X3,...) -> {X1.methodName(X2, X3,...)}
         *  X1::methodName
         *
         *  对象方法引用
         *  final Yy = new Y()
         *  (x1, x2, x3,...) -> { y.methodName(x1, x2, x3,...) }
         *  y::methodName
         */
        Car.create(()->new Car());//需要传一个 方法   ()->new Car()
        Car.create(Car::new);// 这种方法可以简写为 Car::new

    }

}



interface MathOperation {
    int operation(int a, int b);
}

 class Car {
    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }
     public static void collide(final Car car) {
         System.out.println("Collide " + car.toString());
     }
     public void follow(final Car car) {
         System.out.println("Following car " + car.toString());
     }
     public void repair() {
         System.out.println("Repaired car " + this.toString());
     }
}


