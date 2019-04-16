package com.min.design.mode.behavioral.command;

/**
 * 命令模式
 * 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化。
 * 对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
 * 优点：
 *      1.类间解耦
 *      2.可拓展性
 *
 * <p>
 * 命令模式涉及4个角色
 * 1.命令角色
 * 2.具体命令角色
 * 3.调用者角色
 * 4.接受者角色
 */
public class CommandPattern {

    //命令角色
     interface Command {
        void execute();
    }

    //具体命令角色
    static class ConcreteCommand implements Command {
        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            this.receiver.action();
        }
    }

    //接受者角色
    static class Receiver {
        public void action(){
            System.out.println("执行动作");
        }
    }

    //调用者角色
    static class Invoker {
        private Command command;
        //接收命令
        public void setCommand(Command command){
            this.command = command;
        }
        //执行命令
        public void action(){
            this.command.execute();
        }
    }

    public static void main(String[] args) {
        //调用者
        Invoker invoker = new Invoker();
        //接收者
        Receiver receiver = new Receiver();
        //定义命令
        ConcreteCommand command = new ConcreteCommand(receiver);
        //执行
        invoker.setCommand(command);
        invoker.action();
    }
}
