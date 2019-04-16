package com.min.design.mode.composite;

import java.util.ArrayList;

/**
 * 组合模式
 * 将对象组合成数形结构
 * 以表示 部分 - 整体的层次结构
 * 使用户对单个对象和组合对象的使用具有一致性
 *
 * 使用场景：
 *  1.需要描述对象的部分和整体等级结构，如树形菜单，文件夹管理
 *  2.需要客户忽略个体构建和组合构建的区别，平等对待所有构件
 *
 *
 * 组合模式有3个角色
 * 1.抽象构件
 * 2.叶子构件
 * 3.树枝构件
 */
public class CompositePattern {

    //抽象构件
    interface Component{
        void operation();
    }

    //叶子构件
    static class Leaf implements Component{
        @Override
        public void operation() {
            //业务逻辑代码
        }
    }

    //树枝构件
    static class Composite implements Component{
        //构件容器
        private ArrayList<Component> componentArrayList = new ArrayList<>();
        //添加构件
        public void add(Component component){componentArrayList.add(component);}
        //删除构件
        public void remove(Component component){componentArrayList.remove(component);}
        //获取子构件
        public ArrayList<Component> getChild(){return this.componentArrayList;}

        @Override
        public void operation() {//业务逻辑代码
        }
    }

    //使用
    public static void main(String[] args) {
        //创建根节点
        Composite root = new Composite();
        root.operation();
        //创建树枝节点
        Composite branch = new Composite();
        //创建叶子节点
        Leaf leaf = new Leaf();
        //构建树形结构
        root.add(branch);
        branch.add(leaf);
    }

    //遍历树 (递归)
    public static void display(Composite root){
        for(Component c:root.getChild()){
            if(c instanceof Leaf)
                c.operation();
            else{
                c.operation();
                display((Composite)c);
            }
        }
    }
}
