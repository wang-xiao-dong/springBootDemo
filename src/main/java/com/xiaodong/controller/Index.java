package com.xiaodong.controller;

import com.xiaodong.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/24 0024.
 */
@RequestMapping("/test")
@Controller
public class Index {
    @Autowired
    User user;
    @ResponseBody
    @RequestMapping("/index")
    public String test(){
        return "你访问了首页！！"+user.getName()+"===="+user.getAge();
    }
}
