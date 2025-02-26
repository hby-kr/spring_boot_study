package com.tj703.l02_spring_mybatis.mapper;

import com.tj703.l02_spring_mybatis.dto.DeptEmp;
import com.tj703.l02_spring_mybatis.dto.Employees;
import com.tj703.l02_spring_mybatis.dto.Salaries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeesMapper {

    List<Employees> findAll();
    Employees findById(@Param("no") int empNo);
    Employees findWithDeptById(@Param("no") int empNo);
    List<DeptEmp> findDeptEmpById(@Param("no") int deptNo);

    int insert(Employees employees);
    int update(Employees employees);
    int delete(int empNo);
}