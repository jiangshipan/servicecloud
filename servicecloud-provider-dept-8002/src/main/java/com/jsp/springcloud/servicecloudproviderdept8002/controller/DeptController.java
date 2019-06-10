package com.jsp.springcloud.servicecloudproviderdept8002.controller;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import com.jsp.springcloud.servicecloudproviderdept8002.service.DeptService;
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
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
}
