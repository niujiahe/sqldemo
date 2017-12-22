package com.Order_simulation_statistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.Order_simulation_statistics.mapper")
public class Order_simulation_statisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Order_simulation_statisticsApplication.class, args);
	}
}
