package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        System.out.println(employeeRepository.findById(10010));
    }

    @Test
    public void findAllTest() {
        Page<Employee> emppg = employeeRepository.findAll(Pageable.ofSize(10));
        System.out.println(emppg.getContent());

    }

    @Test
    void findByLastName() {
        System.out.println(employeeRepository.findByLastName("최"));
    }

    @Test
    void findByHireDate() {
        List<Employee> empList = employeeRepository.findByHireDate(LocalDate.parse("1985-11-21"));
        System.out.println(empList.size());

    }

    @Test
    void findByHireDateGreaterThan() {
        System.out.println(employeeRepository.findByHireDateGreaterThan(LocalDate.parse("1985-11-21")));
    }

    @Test
    void findByHireDateStartsWith() {
        List<Object[]> empList = employeeRepository.findByHireDateStartsWith("1985-11-21");

        for (Object[] row : empList) {
            String[] stringRow = Arrays.stream(row)
                                        .map(Object::toString)
                                        .toArray(String[]::new);
            System.out.println(Arrays.toString(stringRow));
        }
    }

//    @Test
//    @Transactional
//    void findWithSalaryById() {
//        System.out.println(employeeRepository.findWithSalaryById(10010));
//    }
}