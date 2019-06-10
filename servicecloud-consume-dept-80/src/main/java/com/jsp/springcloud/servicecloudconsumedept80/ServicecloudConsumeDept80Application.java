package com.jsp.springcloud.servicecloudconsumedept80;

import com.jsp.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//自定义负载均衡规则
/**
 * 注意: MySelfRule自定义类,不能放在@ComponentScan包和自包下,
 * 否则这个配置类会被Ribbon客户端共享,也就不能达到特殊化定制的目的了.(当前策略只在当前服务使用)
 * 启动该服务的时候就能去加载我们自定义的Ribbon配置类
 */
@RibbonClient(name="SERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class ServicecloudConsumeDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ServicecloudConsumeDept80Application.class, args);
    }
}
