package com.tj703.l07_spring_jpa_emp_reivew.repository;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Salary;
import com.tj703.l07_spring_jpa_emp_reivew.entity.SalaryId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryId> { // <엔터티 클래스, 기본형pk 타입Integer>


    List<Salary> findByEmpNo(int empNo); // 이렇게만 쓰면 jpa가 알아서 맵핑에서 만듬
    // == SELECT s FROM salaries WHERE empNo = empNo    ;  이것이 자동으로 생성

    // 만약 fetch 방식말고 강제로 sql 쿼리 조인문으로 진행시키고 싶다면 아래와 같은 어노테이션을 적는다.
    // @EntityGraph (attributePaths = {"employee"})
    // List<Salary> findByEmpNo(int empNo);

}
