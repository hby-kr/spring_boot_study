package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.SalaryId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
class SalaryRepositoryTest {

    @Autowired
    private SalaryRepository salaryrepository;

    @Test
    @Transactional
    void findById() {
        SalaryId id = new SalaryId();
        id.setEmpNo(10001);
        id.setFromDate(LocalDate.parse("1986-06-26"));

        System.out.println(salaryrepository.findById(id).get());
    }

    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(salaryrepository.findByEmpNo(10001).toString());
    }
}