package com.boot.quartz.multiplejobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(value = "com.boot.quartz.multiplejobs.db.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class MultiplejobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplejobsApplication.class, args);
	}
}
