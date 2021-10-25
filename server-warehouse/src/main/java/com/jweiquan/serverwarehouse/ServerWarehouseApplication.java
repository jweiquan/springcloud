package com.jweiquan.serverwarehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.jweiquan.serverwarehouse.mapper")
public class ServerWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWarehouseApplication.class, args);
    }

}
