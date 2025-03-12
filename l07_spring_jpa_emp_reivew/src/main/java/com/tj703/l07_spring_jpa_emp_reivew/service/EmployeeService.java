package com.tj703.l07_spring_jpa_emp_reivew.service;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    public Page<Employee> readAll(Pageable pageable);

    Employee readOne(int empNo);

    void remove(Employee employee);

    void save(Employee employee); // jpa는 있으면 수정, 없으면 등록하므로 수정 메서드를 따로 만들 필요가 없다.



}
