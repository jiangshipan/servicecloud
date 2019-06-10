package com.jsp.springcloud.servicecloudeuraka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务端启动类,接受其他服务注册进来
public class ServicecloudEuraka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudEuraka7001Application.class, args);
    }
}
