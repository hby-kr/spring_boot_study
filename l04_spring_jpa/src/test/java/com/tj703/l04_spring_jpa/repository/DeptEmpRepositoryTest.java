package com.tj703.l04_spring_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptEmpRepositoryTest {

    @Autowired
    DeptEmpRepository deptEmpRepository;

    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(deptEmpRepository.findByEmpNo(10010));
    }

    @Test
    @Transactional
    void findByDeptNo() {
        System.out.println(deptEmpRepository.findByDeptNo("d008"));
    }
}