package com.tj703.l03_spring_mybatis_emp.mapper;

import com.tj703.l03_spring_mybatis_emp.model.Departments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentsMapper {
        List<Departments> findAll();

        List<Departments> findAllResultMap();

}