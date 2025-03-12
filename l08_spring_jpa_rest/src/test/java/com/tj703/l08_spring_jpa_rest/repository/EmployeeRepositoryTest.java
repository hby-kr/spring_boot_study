package com.tj703.l08_spring_jpa_rest.repository;

import com.tj703.l08_spring_jpa_rest.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    void findById() {
//        System.out.println(employeeRepository.findById(10001));
        Optional<Employee> empOne = employeeRepository.findById(10001);
        empOne.ifPresent(System.out::println);
    }

}