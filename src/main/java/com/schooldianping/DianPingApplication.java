package com.schooldianping;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ramble
 */

@SpringBootApplication
public class DianPingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DianPingApplication.class, args);
	}

}
