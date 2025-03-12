package com.tj703.l08_spring_jpa_rest.repository;

import com.tj703.l08_spring_jpa_rest.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
