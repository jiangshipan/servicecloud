package com.jsp.springcloud.servicecloudconfig3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServicecloudConfig3344Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudConfig3344Application.class, args);
    }

}
