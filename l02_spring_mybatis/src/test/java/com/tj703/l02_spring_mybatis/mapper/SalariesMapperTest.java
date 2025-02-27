package com.tj703.l02_spring_mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalariesMapperTest {

    @Autowired
    SalariesMapper salariesMapper;

    @Test
    void findById() {
    }

    @Test
    void findSumSalaryById() {
//        System.out.println(salariesMapper.findSumSalaryById(10002));
        System.out.println(salariesMapper.findSumSalaryById(77));
    }
}