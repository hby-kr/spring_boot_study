package com.example.l06_spring_jpa_emp_final.service;

import com.example.l06_spring_jpa_emp_final.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpService {
    /*
    1. 화면에 사원 리스트 (페이징)
    2. 사원 상세 (급여리스트, 직책리스트, 부서이동리스트 join)
    3. 사원 수정 (급여리스트 등록, 직책리스트 등록, 부서이동리스트 등록)
    4. 사원 등록
     */

    Page<Employee> readAll(Pageable pageable);
    // 자바 스프링의 Page 객체는 페이징 처리를 쉽게 도와주는 기능입니다.
    // 대량의 데이터를 처리할 때, 한 번에 모두 로드하는 대신, 페이지 단위로 나눠서 가져오는 방식이 효율적입니다.

    Employee readOneWithSalaiesWithTitlesWithDeptEmps (long id); // 무조건 조인
    Employee readOne (long id); // fetch.Lazy로 필요할 때만 패치

    void save(Employee employee); // 있을 때는 업데이트, 없을 때는 등록

}
