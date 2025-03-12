package com.tj703.l07_spring_jpa_emp_reivew.repository;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@SpringBootTest
class EmpRepositoryTest {

    @Autowired
    private EmpRepository empRepository;

    @Test
    @Transactional
    void findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Employee> empPage = empRepository.findAll(pageable);
        System.out.println(empPage.getContent());
    }
/*
Pageable pageable = PageRequest.of(0, 10);
    Pageable은 인터페이스로, 페이징 정보를 나타냅니다. 이 인터페이스는 페이지 번호와 페이지당 항목 수를 포함합니다.
    PageRequest는 Pageable 인터페이스의 구현체 중 하나입니다.
    of(int page, int size) 메서드를 사용하여 페이지 요청을 생성합니다.
 */

    @Test
    @Transactional
    void findById() {
        Employee emp = empRepository.findById(10001);
        System.out.println(emp);

    }

    @Test
    @Transactional
    void save() {
        Employee emp = new Employee();
        emp.setEmpNo(10002);
        emp.setFirstName("경민");
        emp.setLastName("최");
        emp.setBirthDate(LocalDate.parse("2000-01-01"));
        emp.setHireDate(LocalDate.parse("2025-01-01"));
        emp.setGender(Employee.Gender.M);
        empRepository.save(emp);
    }

    @Test
    @Transactional
    void deleteById() {
        empRepository.deleteById(10002);
    }
}