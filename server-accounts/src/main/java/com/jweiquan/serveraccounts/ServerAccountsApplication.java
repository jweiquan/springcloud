package com.jweiquan.serveraccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAccountsApplication.class, args);
    }

}
