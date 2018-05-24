package com.xiaodong;

import com.xiaodong.java8demo.MyStringFunction;
import org.junit.Test;

/**
 * 测试java8将函数作为参数传递
 * Created by Administrator on 2017/12/17 0017.
 */

public class FunctionDemo {

    @Test
    public void testStrHandler( ) {
        //自定义MyStringFunction中的stringHandler方法为去掉字符串前后空格
       String s =  this.strHandler("  测试去掉空格  ",str -> str.trim());
        System.out.println(s);
        //自定义MyStringFunction中的stringHandler方法为字符转为大写
        String s2 =  this.strHandler("  aaaaAA  ",str -> str.toUpperCase());
        System.out.println(s2);
    }

    //将函数接口MyFunction作为参数进行传递，可执行其中的方法
    public  String strHandler(String str, MyStringFunction myFunction){
        return myFunction.stringHandler(str);
    }

}
