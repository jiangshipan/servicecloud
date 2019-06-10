package com.jsp.springcloud.servicecloudproviderdepthystrix8001.controller;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import com.jsp.springcloud.servicecloudproviderdepthystrix8001.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    //服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }


    /**
     * 在feign接口处写熔断处理 可以与主方法解耦. --> 后续修改
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息,会自动调用HystricxComamand标注好的fallbackMethod中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该id" + id + "没有对应的信息");
        }
        return dept;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.list();
    }


    /**
     * 服务发现 不是重点
     * @return
     */
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("service:" + services);
        List<ServiceInstance> instances = client.getInstances("jsp-servicecloud");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getUri());
        }
        return this.client;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("id:" + id + "没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
