package com.jsp.springcloud.servicecloudconsumedeptfeign.controller;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import com.jsp.springcloud.servicecloudapi.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptService;

    @RequestMapping(value = "/dept/add")
    public boolean add(Dept dept) {
        return this.deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptService.get(id);
    }

    @RequestMapping(value = "/dept/list")
    public List<Dept> list() {
        return this.deptService.getAll();
    }
}
