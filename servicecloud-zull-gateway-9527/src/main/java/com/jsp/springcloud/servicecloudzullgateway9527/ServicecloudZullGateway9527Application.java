package com.jsp.springcloud.servicecloudzullgateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ServicecloudZullGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudZullGateway9527Application.class, args);
    }

}
