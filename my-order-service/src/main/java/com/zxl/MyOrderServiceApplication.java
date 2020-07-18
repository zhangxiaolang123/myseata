package com.zxl;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zxl.feign")
@MapperScan("com.zxl.mapper")
@Import(DataSourceProxyAutoConfiguration.class)
public class MyOrderServiceApplication {
	static Logger logger = LoggerFactory.getLogger(MyOrderServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MyOrderServiceApplication.class, args);
		logger.info("服务启动成功.");
	}

}
