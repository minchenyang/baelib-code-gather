package com.min.design.mode.behavioral.state;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 状态模式
 * 当也给对象内在状态改变时允许改变行为，这个对象看起来像改变了其类型。
 *
 * <p>
 * 涉及三个角色：
 * 1.抽象状态角色
 * 2.具体状态角色
 * 3.环境角色
 *
 * 优点:
 * 1.结构清晰
 * 缺点：
 * 1.子类太多，不易管理
 */
public class StatePattern {

    //抽象状态角色
    static abstract class Status {
        //定义环境角色
        @Setter
        private Context context;

        //抽象行为
        public abstract void handle();
    }

    //具体状态角色
    static class ConcreStatus1 extends Status {
        @Override
        public void handle() {
            System.out.println("状态1的行为逻辑");
        }
    }

    //具体状态角色
    static class ConcreStatus2 extends Status {
        @Override
        public void handle() {
            System.out.println("状态2的行为逻辑");
        }
    }

    //环境角色
    static class Context {
        //定义状态
        public static Status STATUE1 = new ConcreStatus1();
        public static Status STATUE2 = new ConcreStatus2();
        //当前状态
        @Getter
        private Status currentStatus;

        public void setCurrentStatus(Status currentStatus) {
            this.currentStatus = currentStatus;
            //设置状态中的环境
            currentStatus.setContext(this);
        }

        //行为委托1
        public void handle1(){
            //切换状态并且执行
            this.setCurrentStatus(STATUE1);
            this.currentStatus.handle();
        }

        //行为委托2
        public void handle2(){
            //切换状态并且执行
            this.setCurrentStatus(STATUE2);
            this.currentStatus.handle();
        }
    }

    public static void main(String[] args) {
        //定义环境
        Context context = new Context();
        //执行行为
        context.handle1();
        context.handle2();
    }
}
