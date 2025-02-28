package com.tj703.l04_spring_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class titleRepositoryTest {

    @Autowired
    private titleRepository titleRepository;

    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(titleRepository.findByEmpNo(10009));
    }

    @Test
    @Transactional
    void findByTitle() {
        System.out.println(titleRepository.findByTitle("staff"));
    }
}