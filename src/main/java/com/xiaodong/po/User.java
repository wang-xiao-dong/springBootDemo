package com.xiaodong.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by WXD on 2018/5/30 0030.
 */
@Component
public class User {
    @Value("${test.name:wang}")
    private String name;
    @Value("${test.age:1000}")
    private String age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
