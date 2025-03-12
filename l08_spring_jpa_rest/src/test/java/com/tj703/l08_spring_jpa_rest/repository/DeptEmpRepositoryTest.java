package com.tj703.l08_spring_jpa_rest.repository;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptEmpRepositoryTest {

    @Autowired
    DeptEmpRepository deptEmpRepository;

    @Test
    @Transactional
    void findByEmpNo() {
        List<DeptEmp> deptEmps = deptEmpRepository.findByEmpNo(10010);
        System.out.println(deptEmps);

    }
}