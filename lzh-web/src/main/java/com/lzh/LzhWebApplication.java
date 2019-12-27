package com.lzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzh.mapper")
public class LzhWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LzhWebApplication.class, args);
	}

}
