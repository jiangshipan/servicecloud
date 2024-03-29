package com.jsp.springcloud.servicecloudapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@Data
@Accessors(chain = true)//允许链式调用  set1.set2.set3
public class Dept implements Serializable {
    //主键
    private Long deptno;
    //部门名称
    private String dname;
    //来自那个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息存储到不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

}
