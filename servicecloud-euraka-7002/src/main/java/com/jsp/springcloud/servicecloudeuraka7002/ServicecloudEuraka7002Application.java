package com.jsp.springcloud.servicecloudeuraka7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicecloudEuraka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudEuraka7002Application.class, args);
    }

}
