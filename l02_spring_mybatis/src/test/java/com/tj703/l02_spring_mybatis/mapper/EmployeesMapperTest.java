package com.tj703.l02_spring_mybatis.mapper;

import com.tj703.l02_spring_mybatis.dto.Employees;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeesMapperTest {

    @Autowired
    EmployeesMapper empMapper;

    @Order(1)
    @Test
    void findAll() {
        System.out.println(empMapper.findAll());
    }

    @Order(4)
    @Test
    void findById() {
        System.out.println(empMapper.findById(777));
    }

    @Order(2)
    @Test
    void insert() {
        Employees empDto = new Employees();
        empDto.setEmpNo(777);
        empDto.setFirstName("Joe");
        empDto.setLastName("Smith");
        empDto.setBirthDate(LocalDate.parse("2000-01-01"));
        empDto.setHireDate(LocalDate.parse("2025-02-26"));
        empDto.setGender(Employees.Gender.F);

        System.out.println(empMapper.insert(empDto));
    }

    @Order(3)
    @Test
    void update() {
        Employees empDto = new Employees();
        empDto.setEmpNo(777);
        empDto.setFirstName("경만");
        empDto.setLastName("최");
        empDto.setBirthDate(LocalDate.parse("2000-01-01"));
        empDto.setHireDate(LocalDate.parse("2025-02-26"));
        empDto.setGender(Employees.Gender.F);

        System.out.println(empMapper.update(empDto));

    }

    @Order(5)
    @Test
    void delete() {
        System.out.println(empMapper.delete(777));
    }
}