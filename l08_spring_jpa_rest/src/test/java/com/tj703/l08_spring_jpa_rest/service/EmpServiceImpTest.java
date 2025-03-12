package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.Employee;
import com.tj703.l08_spring_jpa_rest.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class EmpServiceImpTest {

    @Autowired
    EmployeeRepository empService;

    @Test
    @Transactional
    void readAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Employee> empPage = empService.findAll(pageable);
        System.out.println(empPage.getContent()); // empPage 안에 리스트 값을 가져오는 것

    }

    @Test
    void readOne() {

    }

}