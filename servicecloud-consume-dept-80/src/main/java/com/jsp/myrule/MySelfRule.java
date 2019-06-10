package com.jsp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    /**
     * 需求: 轮询策略, 加上新需求,每个服务器要求被调用5次.
     */

    @Bean
    public IRule myRule() {
        //return new RandomRule();//随机
        //使用自定义负载均衡规则
        return new RandomRule_self();
    }


}
