package com.example.l06_spring_jpa_emp_final.repository;

import com.example.l06_spring_jpa_emp_final.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> { // <엔터티 객체, PK의 타입>

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFirstName(Pageable pageable, String firstName);


    // 강제로 조인하기
    @EntityGraph(attributePaths = {"salaries", "deptEmps", "deptEmps.department"})
    Employee findWithSalariesWithDeptEmpsById(int id);

}
