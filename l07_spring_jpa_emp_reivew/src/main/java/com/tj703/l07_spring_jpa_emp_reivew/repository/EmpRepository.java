package com.tj703.l07_spring_jpa_emp_reivew.repository;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // 이제 Bean이 됨
public interface EmpRepository extends JpaRepository<Employee, Integer> {
//                           <Employee, Integer> == <엔터티 클래스, 기본형pk 타입Integer>

    // select * from employees Order by ? ? limit ?, ?
    Page<Employee> findAll (Pageable pageable); // Page<Employee>는 page네비게이션정보 + List<Employee>
    // 이미 jpa가 설계 되어 있어서, 오버라이드 할거 아니면 따로 명시안해도 됨


    Employee findById(int empNo);

    Employee save(Employee employee); // 이미 구현되어 있는 save는 객체를 반환. 따라서 void 아님.

    void deleteById(int empNo);
}
    /*
    Page 객체는 그래서 왜 쓰는가?

    Page 객체는 페이징 처리(pagination)를 위해 사용됩니다. 데이터베이스에서 많은 양의 데이터를 한 번에 조회할 경우 성능 문제나 메모리 오버헤드가 발생할 수 있습니다. 그래서 데이터를 여러 페이지로 나누어 필요한 부분만을 한 번에 조회하는 것이 중요합니다. Page 객체는 이 작업을 쉽게 처리할 수 있도록 도와줍니다.


     */

