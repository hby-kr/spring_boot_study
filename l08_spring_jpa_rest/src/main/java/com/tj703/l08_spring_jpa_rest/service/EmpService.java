package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmpService {

    // 사원 상세 페이지
    Optional<Employee> readOne (int emp_no);

    // 사원 리스트 페이징
    Page<Employee> readAll (Pageable pageable);

}
