package com.jsp.springcloud.servicecloudconsumerhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ServicecloudConsumerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudConsumerHystrixDashboardApplication.class, args);
    }

}
