package com.min.baelibcodegather.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主要有2个类：
 *      Pattern 表示正则表达式的对象，他与要处理的字符无关。
 *
 *      Matcher 表示一个匹配, 它将表达式应用与一个具体的字符串，通过它对字符串进行处理。
 *
 *      String 也有直接接受正则表达式的方法。
 */
public class Regular {
    public static void main(String[] args) {

        String regex = "<(\\w+)>(.*)</\\1>";
        //线程安全
        Pattern compile1 = Pattern.compile(regex);
        /**
         * 可以指定模式：
         *      1.单行模式               Pattern.DOTALL
         *      2.多行模式               Pattern.MULTILINE
         *      3.大小写无关模式          Pattern.CASE_INSENSITIVE
         *      4.使表达式元字符失去含义   Pattern.LITERAL
         * 多模式 可以使用 | 链接即可
         */
        Pattern compile2 = Pattern.compile(regex,Pattern.LITERAL);

        /**
         * 切分
         */
        String string = "abc,def,ggg";
        String[] split = string.split(",");//若是元数据需要转义
        String quote = Pattern.quote(".");//若事先不知道分隔符 调用此方法以免没有转义
        /**
         *pattern的分割
         * 区别：
         *  1.CharSequence 接受  String StringBuffer StringBuilder CharBuffer
         *  2.若regex长度大于1 或 包含元字符 则还是调用此方法，避免重复调用，直接调用此方法。 反正调用 String 它有更高效的方法。
         */
        String[] split1 = compile1.split(string);//CharSequence


        /**
         * 验证
         * 实际调用的还是 pattern方法
         */
        string.matches("");


        /**
         * 查找
         */
         String regx = "\\d{4}-\\d{2}-\\d{2}";
         Pattern pattern3 = Pattern.compile(regx);
         String rtr = "today is 2017-06-02, yesterday is 2017-06-01";
        Matcher matcher = pattern3.matcher(rtr);
        //find2017-06-02position:9-19
        //find2017-06-01position:34-44
        /**
         * matcher.group() 匹配到的字串
         * matcher.start() 字串起始位置
         * matcher.end()   字串结束位置 +1
         * group() 调用 group(0)
         * 还有
         * groupCount() //分组个数
         * 等
         */
        while(matcher.find()){
            System.out.println("find"+matcher.group() + "position:" + matcher.start() + "-" +matcher.end());
        }

        /**
         * 替换
         */
        String replace = "replace";
        replace.replace('C','C');//操作单个字符
        replace.replace("","");//字符串  都看做为普通字符
        replace.replaceAll("","");// 看作正则  全部
        replace.replaceFirst("","");// 看作正则  第一个
    }
}
