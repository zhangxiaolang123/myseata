package com.zxl;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.zxl.mapper")
@Import(DataSourceProxyAutoConfiguration.class)
public class MyAccountServiceApplication {
	static Logger logger = LoggerFactory.getLogger(MyAccountServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MyAccountServiceApplication.class, args);
		logger.info("服务启动成功.");
	}

}
