package com.jsp.springcloud.servicecloudapi.service;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断统一放到该类
 */
@Component //不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id)
                        .setDname("该id"+ id + "没有对应的信息,Consumer客户端提供的服务降级信息")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> getAll() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
