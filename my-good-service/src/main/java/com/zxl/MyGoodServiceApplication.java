package com.zxl;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DataSourceProxyAutoConfiguration.class)
@MapperScan("com.zxl.mapper")
public class MyGoodServiceApplication {
	static Logger logger = LoggerFactory.getLogger(MyGoodServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MyGoodServiceApplication.class, args);
		logger.info("服务启动成功.");
	}

}
