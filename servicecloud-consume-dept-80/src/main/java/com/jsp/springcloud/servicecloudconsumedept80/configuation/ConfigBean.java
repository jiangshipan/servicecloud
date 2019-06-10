package com.jsp.springcloud.servicecloudconsumedept80.configuation;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConfigBean = applicationContext.xml
 */
@Configuration
public class ConfigBean {

    /**
     * restTemplate提供了多种便捷访问远程http服务的方法,
     * 是一种简单便捷的访问restful服务的模板类,是Spring提供
     * 用于访问rest服务的客户端模板工具集
     * @return
     */
    @Bean
    @LoadBalanced//ribbon实现的一套客户端,负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 配置负载均衡算法  引入ribbon提供的负载均衡算法.
     * @return
     */
//    @Bean
//    public IRule myRule()  {
//        //用我们选择的随机算法
//        return new RandomRule();
//    }
}
