package com.jsp.springcloud.servicecloudproviderdepthystrix8001.service;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import com.jsp.springcloud.servicecloudproviderdepthystrix8001.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptDao deptDao;

    public boolean add(Dept dept) {
        deptDao.addDept(dept);
        return true;
    }

    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    public List<Dept> list() {
        return deptDao.findAll();
    }
}
