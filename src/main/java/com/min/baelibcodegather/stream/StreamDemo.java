package com.min.baelibcodegather.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream  思想: 遍历
 * 一个流的生命周期分为三个阶段：
 * 1.生成
 * 2.操作，转变(可以多次)
 * 3.消耗(只有一次)
 *
 * 详细：https://www.jianshu.com/p/9fe8632d0bc2
 */
public class StreamDemo {

    public static void main(String[] args) {
        /**
         * 生成
         */
        //对象
        Stream<String> stream1 = Stream.of("a", "b", "c");
        //数组
        String[] strings = {"a", "b", "c"};
        Stream<String> stream2 = Stream.of(strings);
        Stream<String> stream3 = Arrays.stream(strings);
        //集合
        List<String> list = Arrays.asList(strings);
        Stream<String> stream4 = list.stream();
        //生成DoubleSteam、IntSteram或LongStream对象（这是目前支持的三个数值类型Stream对象）
        IntStream.of(new int[]{1, 2, 3}); // 根据数组生成
        IntStream.range(1, 3); // 按照范围生成，不包括3
        IntStream.rangeClosed(1, 3); // 按照范围生成，包括3

        /**
         * 变换
         * 一个流可以经过多次的变换，变换的结果仍然是一个流。
         * 常见的变换：map (mapToInt, flatMap 等)、 filter -- 用于通过设置条件过滤出元素、 distinct、 sorted、 peek、
         * limit、 skip、 parallel -- 是流并行处理程序的代替方法 、 sequential、 unordered
         */

        /**
         * 消耗
         * 一个流对应一个消耗操作。
         * 常见的消耗操作：forEach -- 来迭代流中的每个数据、 forEachOrdered、 toArray、 reduce、 collect -- 很多归约操作、 min、
         * max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
         */


        /**
         * 例子
         */
        List<Student> students = Arrays.asList(
                new Student("Fndroid", 22, Student.Sex.MALE, 180),
                new Student("Jack", 20, Student.Sex.MALE, 170),
                new Student("Liliy", 18, Student.Sex.FEMALE, 160)
        );

        //循环：
        students.stream().filter(student -> student.getSex() == Student.Sex.MALE)// 进行过滤
                         .forEach(System.out::println);// 输出

        //求出所有学生的平均年龄：
        OptionalDouble averageAge = students.stream()
                .mapToInt(Student::getAge) // 将对象映射为整型
                .average(); // 根据整形数据求平均值
        //可以看到这里的average方法得到一个OptionalDouble类型的值，这也是Java8的新增特性，
        //OptionalXXX类用于减少空指针异常带来的崩溃，可以通过orElse方法获得其值，如果值为null，则取默认值0。
        System.out.println("所有学生的平均年龄为：" + averageAge.orElse(0));

        //.输出每个学生姓名的大写形式：
        List<String> names = students.stream()
                .map(Student::getName) // 将Student对象映射为String（姓名）
                .map(String::toUpperCase) // 将姓名转为小写
                .collect(Collectors.toList()); // 生成列表
        System.out.println("所有学生姓名的大写为：" + names);

      //按照年龄从小到大排序：
        List<Student> sortedStudents = students.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge()) // 按照年龄排序
                .collect(Collectors.toList()); // 生成列表
        System.out.println("按年龄排序后列表为：" + sortedStudents);

        //判断是否存在名为Fndroid的学生：
        boolean isContain = students.stream()
                .anyMatch(student -> student.getName().equals("Fndroid")); // 查询任意匹配项是否存在
        System.out.println("是否包含姓名为Fndroid的学生：" + isContain);

        //将所有学生按照性别分组：
        Map<Student.Sex, List<Student>> groupBySax = students.stream()
                .collect(Collectors.groupingBy(Student::getSex)); // 根据性别进行分组
        System.out.println(groupBySax.get(Student.Sex.FEMALE));

        //求出每个学生身高比例
        double sumHeight = students.stream().mapToInt(Student::getHeight).sum(); // 求出身高总和
        DecimalFormat formator = new DecimalFormat("##.00"); // 保留两位小数
        List<String> percentages = students.stream()
                .mapToInt(Student::getHeight) // 将Student对象映射为身高整型值
                .mapToDouble(value -> value / sumHeight * 100) // 求出比例
                .mapToObj(per -> formator.format(per) + "%") // 组装为字符串
                .collect(Collectors.toList());
        System.out.println("所有学生身高比例：" + percentages);
    }

}

@Data
@AllArgsConstructor
class Student{
    public enum Sex{
        FEMALE, MALE
    }
    private String name;
    private int age;
    private Sex sex;
    private int height;
}