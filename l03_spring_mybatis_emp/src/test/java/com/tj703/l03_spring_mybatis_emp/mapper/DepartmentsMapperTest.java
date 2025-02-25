package com.tj703.l03_spring_mybatis_emp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentsMapperTest {

    @Autowired
    DepartmentsMapper departmentsMapper;
    // session factory가 mapper 인터페이스를 xml 기반으로 구현 후 객체를 만들어서 주입

    @Test
    void findAll() {
        System.out.println(departmentsMapper.findAll());
    }

    @Test
    void findAllResultMap() {
        System.out.println(departmentsMapper.findAllResultMap());
    }
}