package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.entity.Salary;
import com.tj703.l04_spring_jpa.entity.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployServiceTest {

    @Autowired
    private EmployService employService;

    @Test
    void entityManagerTest() {
        employService.entityManagerTest();
    }

    @Test
    void modifyEmpSaveSalariesAndTitles() {
        Employee emp = new Employee();
        emp.setGender("F");
        emp.setFirstName("최최최최test");
        emp.setLastName("testtest");
        emp.setBirthDate(LocalDate.parse("2000-01-01"));
        emp.setHireDate(LocalDate.parse("2020-01-01"));
        emp.setId(10001);

        Salary salary = new Salary();
        salary.setSalary(9);
        salary.setEmpNo(10001);
        salary.setFromDate(LocalDate.parse("2020-01-01"));
        salary.setToDate(LocalDate.parse("2020-01-30"));
        emp.getSalaries().add(salary);

        Title title = new Title();
        title.setTitle("모르겠음");
        title.setEmpNo(10001);
        title.setFromDate(LocalDate.parse("2020-01-01"));
        title.setToDate(LocalDate.parse("2020-01-30"));
        emp.getTitles().add(title);

        Title title2 = new Title();
        title2.setTitle("모르겠음2");
        title2.setEmpNo(10001);
        title2.setFromDate(LocalDate.parse("2020-01-30"));
        title2.setToDate(LocalDate.parse("2020-01-30"));
        emp.getTitles().add(title2);

        employService.modifyEmpSaveSalariesAndTitles(emp);
    }
}