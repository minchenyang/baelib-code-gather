package com.min.design.mode.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式
 * 按照规定语法对表达式进行解析的方案。
 *
 * 优点：
 *
 *
 *
 * 涉及5个角色：
 * 1.抽象表达式
 * 2.终结符表达式
 * 3.非终结符表达式
 * 4.环境
 * 5.客户端
 */
public class InterpreterPattern {
    //抽象表达式
    static abstract class AbstractExpression {
        //每个表达式必须有一个解析任务
        public abstract Object interpreter(Context context);
    }
    //终结符表达式
    static class TerminalExpression extends AbstractExpression{

        //通常终结符表达式只有一个，但是有多个对象
        @Override
        public Object interpreter(Context context) {
            return null;
        }
    }
    //非终结符表达式
    static class NoterminalExpression extends AbstractExpression{

        //非终结符表达式都会对其他表达式产生依赖

        public NoterminalExpression(AbstractExpression expression) {
        }

        @Override
        public Object interpreter(Context context) {
            //进行文法处理
            return null;
        }
    }

    //环境
    static class Context{
        private HashMap map = new HashMap();
    }

    //客户端
/*    public static void main(String[] args) {
        Context context = new Context();
        for (;;){
            //进行语法判断，并产生递归调用
        }
    }*/

    /**
     * 例子：四则运算表达式计算
     */

    /**
     * 此接口代表算术表达式，对应解释器模式中的抽象接口
     */
    interface ArithmeticExpression{
        int interpret(Variables variables);
    }

    /**
     * 对应 环境角色
     */
    static class Variables {
        Map<Variable, Integer> v = new HashMap<>();
        public void put(Variable variable, Integer integer){
            v.put(variable, integer);
        }
        public int get(Variable variable){
            return v.get(variable);
        }
    }

    /**
     * 此类代表变量，对应解释器模式中的终结符表达式
     */
    static class Variable implements ArithmeticExpression{
        @Override
        public int interpret(Variables variables) {
            return variables.get(this);
        }
    }

    /**
     * Plus Substract Multiply Division 类分别代表了 加减乘除运算 对应解释器模式中的非终结符表达式
     */
    public static class Plus implements ArithmeticExpression{
        ArithmeticExpression left;
        ArithmeticExpression right;

        public Plus(ArithmeticExpression left, ArithmeticExpression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Variables variables) {
            return left.interpret(variables) + right.interpret(variables);
        }
    }

    public static class Subtract implements ArithmeticExpression{
        ArithmeticExpression left;
        ArithmeticExpression right;

        public Subtract(ArithmeticExpression left, ArithmeticExpression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Variables variables) {
            return left.interpret(variables) - right.interpret(variables);
        }
    }

    public static class Multiply implements ArithmeticExpression{
        ArithmeticExpression left;
        ArithmeticExpression right;

        public Multiply(ArithmeticExpression left, ArithmeticExpression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Variables variables) {
            return left.interpret(variables) * right.interpret(variables);
        }
    }

    public static class Division implements ArithmeticExpression{
        ArithmeticExpression left;
        ArithmeticExpression right;

        public Division(ArithmeticExpression left, ArithmeticExpression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Variables variables) {
            return left.interpret(variables) / right.interpret(variables);
        }
    }

    public static void main(String[] args) {
        Variables v = new Variables();
        Variable x = new Variable();
        Variable y = new Variable();
        Variable z = new Variable();

        v.put(x, 10);
        v.put(y, 20);
        v.put(z, 30);

        //计算 x * ( y + z / x) - x
        ArithmeticExpression e = new Subtract(new Multiply(x, new Plus(y, new Division(z,x))), x);
        System.out.println(e.interpret(v));
    }
}
