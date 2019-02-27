package com.min.baelibcodegather.lambda;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

/**
 * 函数的复合
 */
public class RecombinationLambda {

    public static void main(String[] args) {

    }


    public static<T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        //函数式接口   方法能直接转换为对象
        return (Comparator<T> & Serializable)
                (c1, c2) -> Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
    }

}
