package com.xiaodong;

import com.xiaodong.java8demo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的操作方式
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 * 注：当流创建了没有进行终端操作命令时，其各种中间操作均不会执行
 * Created by Administrator on 2017/12/17 0017.
 */
public class StreamDemo {

    //1、**********创建Stream**************

    @Test
    public void test1(){
        //1. 集合类获取流：Collection 提供了两个方法：获取串行流stream() 与 并行流parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);//从0开始，每次加2来获取数据流
        stream3.forEach(System.out::println);

        //使用Stream的生成方法（获取的是无限多个）
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);//截取前2个
        stream4.forEach(System.out::println);
    }

    //2、**********Stream中间操作**************
    /*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
    //构造集合数据
    List<Employee> employees = Arrays.asList(
            new Employee("张三",15),
            new Employee("李四",17),
            new Employee("王五",14),
            new Employee("赵六",19),
            new Employee("阿狗",25),
            new Employee("阿狗",25)
    );

    @Test
    public void test(){
        employees.stream()
                .filter((e) -> e.getAge() >= 17)//取年龄大于等于17的
                .limit(2)//取前两个
                .forEach(System.out::println);

        employees.stream()
                .filter((e) -> e.getAge() >= 17)//取年龄大于等于17的
                .skip(2)//跳过前两个
                .forEach(System.out::println);

        employees.stream()
                .filter((e) -> e.getAge() >= 17)//取年龄大于等于17的
                .distinct()//安照对象的equals和hashCode方法去重
                .forEach(System.out::println);
    }

	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
    @Test
    public void testMap(){

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<String> stream = strList.stream()
                                        .map(String::toUpperCase);//map传入的参数是集合中的每个元素，返回的结果是一个流，
        stream.forEach(System.out::println);

        strList.stream()
                .map(strs ->{ //flatMap传入的参数也是一个流，其返回的也是一个流，只是其会将多个流合并为一个流
                    List<Character> list = new ArrayList<>();
                    for (Character ch : strs.toCharArray()) {
                        list.add(ch);
                    }
                    return list.stream();
                })
                .forEach(System.out::println);
        System.out.println("--------比较map与flatMap------");
        strList.stream()
                .flatMap(strs ->{ //flatMap传入的参数也是一个流，其返回的也是一个流，只是其会将多个流合并为一个流
                    List<Character> list = new ArrayList<>();
                    for (Character ch : strs.toCharArray()) {
                        list.add(ch);
                    }
                    return list.stream();
                })
                .forEach(System.out::println);

        System.out.println("--------将方法函数单独提出来，作为参数传入------");
        //等价于
        Stream<Character> stream3 = strList.stream()
                .flatMap(StreamDemo::filterCharacter); //单独提出方法filterCharacter

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
}
