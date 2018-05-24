package com.xiaodong;



import com.xiaodong.java8demo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
public class CollectionDemo {
    //构造集合数据
    List<Employee> employees = Arrays.asList(
            new Employee("张三",15),
            new Employee("李四",17),
            new Employee("王五",14)
    );

    //按条件过滤掉集合中某些元素(集合自身不会变化)
    @Test
    public void filterList() {
        employees.stream()
                 .filter((e) -> e.getAge() <= 15)//只保留年龄小于等于15的
                 .forEach(e -> System.out.println("年龄为："+e.getAge()));
        System.out.println("-------------------"+employees.size());
    }

    //取出集合中对象的某个属性作为新集合
    @Test
    public void getElementsList() {
        employees.stream()
                .map(Employee::getName) //取出name
                .limit(2) //取前两个（按原集合顺序）
                .forEach(System.out::println);
    }

    //集合排序
   @Test
   public void sortList( ) {
        //按对象的compareTo方法排序
       employees.stream()
                .map(e -> e.getAge())
                .sorted()
                .forEach(System.out::println);

        //自定义排序：先按年龄排序，再按名称的hashCode排序
       employees.stream()
                .sorted((e1,e2) -> {
                   if (e1.getAge() == e2.getAge()){
                       return e1.getName().compareTo(e2.getName());
                   } else {
                       return  Integer.compare(e1.getAge(),e2.getAge());
                   }
               })
                .forEach(e -> System.out.println(e.getAge()));
   }
}
