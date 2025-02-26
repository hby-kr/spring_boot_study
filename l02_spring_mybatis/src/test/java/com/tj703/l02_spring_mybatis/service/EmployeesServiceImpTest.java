package com.tj703.l02_spring_mybatis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class EmployeesServiceImpTest {

    @Autowired
    EmployeesService empService;


    @Test
    void readAll() {
        System.out.println(empService.readAll());
    }

    @Test
    void read() {
        System.out.println(empService.read(77));
    }

    @Test
    void register() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}