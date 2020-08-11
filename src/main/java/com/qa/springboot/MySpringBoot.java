package com.qa.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qa.springboot.mapper")
public class MySpringBoot {
	public static void main(String[] args) {
		SpringApplication.run(MySpringBoot.class, args);
	}

}
