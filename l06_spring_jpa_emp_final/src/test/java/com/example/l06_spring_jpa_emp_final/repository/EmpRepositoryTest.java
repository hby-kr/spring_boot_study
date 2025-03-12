package com.example.l06_spring_jpa_emp_final.repository;

import com.example.l06_spring_jpa_emp_final.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpRepositoryTest {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void proxyTest() {
        /*
        프록시(대리인) 디자인 패턴 (프록시 객체)
        프록시 객체는 실제 객체를 대신하여 특정 작업을 수행하는 대리 객체입니다.
        생성과 관련된 객체다.

        fetch.lazy 지연조회에서 요청하는 객체를 프록시 객체가 대신하고 있음

        일반적으로 프록시 패턴은 객체에 대한 접근을 제어하거나 추가 기능을 제공하는 데 사용됩니다.
        자바 스프링에서 프록시 객체는 AOP(관점지향프로그래밍, Aspect-Oriented Programming)나 지연 로딩 같은 기능을 구현할 때 자주 사용.
        AOP 프록시: 주로 메서드 호출 전후에 로깅, 트랜잭션 관리, 보안 검사 등의 부가 기능을 추가할 때 사용됩니다.
        JPA 프록시: 엔티티를 지연 로딩(Lazy Loading)할 때 사용됩니다. 즉, 실제 데이터베이스 조회는 필요할 때까지 지연되고, 대신 프록시 객체가 사용됩니다.
         */

        Employee proxyEmp = entityManager.getReference(Employee.class, 10001);
        System.out.println(proxyEmp.getClass()); // type확인 / Employee$HibernateProxy$tBv8jkUn / 즉 대리객체인 것을 알 수 있다.
        System.out.println(proxyEmp instanceof Employee); // true / 해당 대리객체의 부모가 Employee인가

    }


    @Test
    @Transactional
    void testFindAll() {
        // Pageable pageable = PageRequest.ofSize(10);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(1, 5).withSort(sort);
        Page<Employee> empPage = empRepository.findAll(pageable);
        System.out.println(empPage.getContent()); // List로 반환
    }

    @Test
    @Transactional
    void findByFirstName() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 10).withSort(sort);
        Page<Employee> empPage = empRepository.findByFirstName(pageable, "Parto");
        System.out.println(empPage.getContent());
    }


    @Test
    @Transactional
    void findWithSalariesById() {
        System.out.println(empRepository.findWithSalariesWithDeptEmpsById(10010));
    }
}