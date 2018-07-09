package com.boot.quartz.multiplejobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Slf4j
@MapperScan(value = "com.boot.quartz.multiplejobs.db.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class MultiplejobsApplication {

	public static void main(String[] args) {
		try{
			ConfigurableApplicationContext context = SpringApplication.run(MultiplejobsApplication.class, args);

		}catch (Exception e){
			log.error("Env config Run："+e);
			throw e;
		}
		}
}
