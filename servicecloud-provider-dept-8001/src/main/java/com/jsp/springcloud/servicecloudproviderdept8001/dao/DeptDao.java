package com.jsp.springcloud.servicecloudproviderdept8001.dao;

import com.jsp.springcloud.servicecloudapi.model.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("deptDao")
public interface DeptDao {
    String TABLE_NAME = "dept";
    String INSERT_FIELD = "dname,db_source";

    @Insert({"insert into", TABLE_NAME, INSERT_FIELD, "values(dname,db_source)"})
    void addDept(Dept dept);

    @Select({"select * from", TABLE_NAME, "where deptno = #{deptno}"})
    Dept findById(Long deptno);

    @Select({"select * from",TABLE_NAME})
    List<Dept> findAll();

}
