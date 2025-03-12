package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import com.tj703.l08_spring_jpa_rest.entity.DeptEmpId;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {

    List<DeptEmp> readByEmpNo (int empNo);

    DeptEmp save(DeptEmp deptEmp);

    void register(DeptEmp deptEmp);



    void remove(DeptEmpId deptEmpId);
}
