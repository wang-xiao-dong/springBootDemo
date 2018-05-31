package com.xiaodong;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.xiaodong.po.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//指定从配置中心可获取的name space
@EnableApolloConfig({"application"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	/*@Bean
	public User javaConfigBean() {
		return new User();
	}*/
}
