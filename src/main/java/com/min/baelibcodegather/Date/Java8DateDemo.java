package com.min.baelibcodegather.Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 日期类的增强
 *  Java8新增的所有日期类都在包java.time下，而且都是final class和线程安全。\
 *  LocalDateTime：日期+时间 yyyy-MM-dd HH:mm:ss，替代Calendar
 *  LocalDate：日期，yyyy-MM-dd
 *  LocalTime：时间，HH:mm:ss
 *  YearMonth：年月，比如信用卡的日期类型
 *  MonthDay：月日，比如生日
 *  DateTimeFormatter：日期格式化类，替代SimpleDateFormat
 *  Instant：替代Date
 *  还有很多枚举类，月份枚举Month、星期枚举DayOfWeek、Year类（可以判断闰年）等等。
 *
 */
public class Java8DateDemo {
    public static void main(String[] args) {
        /**
         * 获取当日日期
         */
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();         //获取年
        int month = localDate.getMonthValue();  //获取月
        int day = localDate.getDayOfMonth();    //获取日

        /**
         * 获取输入日期
         */
        LocalDate localDate2 = LocalDate.of(1994,8,24);

        /**
         * 日期的比较
         * java8时间类重写equals（）方法，可用于对比日期。
         */
        LocalDate localDate3 = LocalDate.of(1994,8,24);
        LocalDate localDate4 = LocalDate.now();
        localDate3.equals(localDate4);

        /**
         * 时间的增加减少
         * /使用plus**（Long i）来增加对应的时间数
         * public LocalTime plusHours(long hoursToAdd)    ;     //增加小时
         * 也可通过plus（）方法增加减少时间数  amountToAdd：增加的数  unit:对应的时间单位   例：ChronoUnit.Days  ->  增加天数
         * public LocalDate plus(long amountToAdd, TemporalUnit unit)
         *
         *
         * 判断一个日期在另一个日期之前或之后
         */
        LocalDate today = LocalDate.now();
        LocalDate tommorow = today.plus(1, ChronoUnit.DAYS);
        tommorow.isAfter(today);                 //true
        tommorow.isBefore(today);

        /**
         * 处理不同的时区
         */
        LocalDateTime localDateTime = LocalDateTime.now();   //本地时间
        ZoneId zone = ZoneId.of(ZoneId.SHORT_IDS.get("ACT")); //时区
        //ZonedDateTime dateTimeInNewYork = localDateTime.of(localDateTime,zone);//时区时间

    }
}
