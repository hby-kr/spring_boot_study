package com.tj703.l07_spring_jpa_emp_reivew.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalaryRepositoryTest {

    @Autowired
    private SalaryRepository salaryRepository;

    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(salaryRepository.findByEmpNo(10010));
    }
}