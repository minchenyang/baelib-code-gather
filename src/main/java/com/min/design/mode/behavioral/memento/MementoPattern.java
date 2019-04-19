package com.min.design.mode.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.LinkedList;

/**
 * 备忘录模式
 * 将一个对象进行备份， 提供一种程序数据备份的方法。
 *
 * <p>
 * 使用场景：
 * 1.需要保存和恢复数据相关状态场景
 * 2.提供一个可回滚操作
 *
 * <p>
 * 涉及三个角色：
 * 1.发起人
 * 2.备忘录
 * 3.负责人
 */
public class MementoPattern {

    //发起人
    @Data
    static
    class Originator {
        private String status;

        //创建备忘录
        public Memento createMemento() {
            return new Memento(1, this.status, "");
        }

        //恢复一个备忘录
        public void restoreMemento(Memento memento) {
            this.setStatus(memento.getState());
        }
    }

    //备忘录
    @Data
    @AllArgsConstructor
    static
    class Memento {
        //版本
        private int version;
        //状态
        private String state;
        //内容
        private String context;
    }

    //负责人
    @Data
    static
    class VersionControlSystem {
        LinkedList<Memento> list = new LinkedList<>();

        //添加备份
        public void add(Memento memento) {
            this.list.add(memento);
        }

        //获取某个版本的备份
        public Memento get(int version) {
            for (Memento memento : list) {
                if (memento.getVersion() == version) {
                    return memento;
                }
            }
            return null;
        }

        //获取最后一个版本
        public Memento getLastVersion(){
            return list.getLast();
        }
    }

}
