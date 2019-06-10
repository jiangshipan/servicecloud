package com.jsp.springcloud.servicecloudproviderdept8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//注册服务进eureka Client
@EnableDiscoveryClient//服务发现- >> 对外展现服务功能(不是重点)
public class ServicecloudProviderDept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudProviderDept8001Application.class, args);
    }

}
