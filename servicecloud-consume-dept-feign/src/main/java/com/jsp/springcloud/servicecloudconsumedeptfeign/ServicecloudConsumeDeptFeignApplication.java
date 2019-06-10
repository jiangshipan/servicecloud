package com.jsp.springcloud.servicecloudconsumedeptfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jsp.springcloud"})
@ComponentScan("com.jsp.springcloud")
public class ServicecloudConsumeDeptFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudConsumeDeptFeignApplication.class, args);
    }

}
