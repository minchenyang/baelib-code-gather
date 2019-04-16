package com.min.baelibcodegather;

import com.min.design.mode.factory.FactoryMethodPattern;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class BaelibCodeGatherApplicationTests {

    @Test
    public void contextLoads() {
        String s1 = "/adadad/qeqrwr/gdfgsg/rwerwer/qwrwer";
        String s2 = "";
        String replace = s1.replace("/adadad/qeqrwr/gdfgsg1/", "/aaa/");
        System.out.println(replace);
    }



    class Factory {
        public  <T> T factory(Class<T> c) {
            T abstractProduct = null;
            try {
                abstractProduct = (T) Class.forName(c.getName()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return abstractProduct;
        }
    }
}
