package com.tj703.l03_spring_mybatis_emp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeesMapperTest {

    @Autowired
    EmployeesMapper employeesMapper;

    @Test
    void testFindAll() {
        System.out.println(employeesMapper.findAll());
    }

    @Test
    void findByEmpNo() {
        System.out.println(employeesMapper.findByEmpNo(10001));
    }
}