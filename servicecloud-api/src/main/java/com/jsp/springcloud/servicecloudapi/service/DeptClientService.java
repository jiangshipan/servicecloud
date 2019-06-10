package com.jsp.springcloud.servicecloudapi.service;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "SERVICECLOUD-DEPT")
//加上熔断处理
@FeignClient(value = "SERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/getAll", method = RequestMethod.GET)
    List<Dept> getAll();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);


}
