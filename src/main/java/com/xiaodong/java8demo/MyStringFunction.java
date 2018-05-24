package com.xiaodong.java8demo;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
//使用注解表明这是一个函数式接口
    //函数式接口：里面只有一个public方法
@FunctionalInterface
public interface MyStringFunction {
    public  String stringHandler(String string); //定义一个处理字符串的方法
}
