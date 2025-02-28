package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {



}
/*
JpaRepository는 JPA를 사용하는 Spring Data JPA에서 제공하는 인터페이스로,
데이터베이스 작업을 쉽게 처리할 수 있도록 다양한 기본 메서드를 제공

1. 기본 CRUD 메서드
기본적인 Create, Read, Update, Delete 작업을 수행하는 메서드들입니다.
    Create, Update,
    // save메서드는 엔티티의 생성(Create)과 업데이트(Update) 두 가지 기능을 모두 수행
        save(S entity): 엔티티를 저장합니다.
        saveAll(Iterable<S> entities): 여러 엔티티를 저장합니다.

    Read
        findById(ID id): ID로 엔티티를 조회합니다.
        existsById(ID id): ID로 엔티티가 존재하는지 확인합니다.
        findAll(): 모든 엔티티를 조회합니다.
        findAllById(Iterable<ID> ids): 여러 ID로 엔티티를 조회합니다.
        count(): 엔티티의 수를 반환합니다.

    Delete
        deleteById(ID id): ID로 엔티티를 삭제합니다.
        delete(T entity): 엔티티를 삭제합니다.
        deleteAll(Iterable<? extends T> entities): 여러 엔티티를 삭제합니다.
        deleteAll(): 모든 엔티티를 삭제합니다.

2. 페이징 및 정렬 메서드
페이징 및 정렬 메서드는 데이터베이스에서 대량의 데이터를 효율적으로 조회하고, 원하는 순서대로 정렬할 수 있도록 도와줍니다.
    개념 먼저.
    - 페이지(Page): 전체 데이터를 일정한 크기로 나눈 각 조각.
    - 페이지 크기(Page Size): 한 페이지에 포함될 데이터의 개수.
    - 페이지 번호(Page Number): 조회할 페이지의 인덱스(0부터 시작).

        1. findAll(Pageable pageable): 페이징된 엔티티를 조회합니다.
        2. findAll(Sort sort): 정렬된 엔티티를 조회합니다.
        3. findAll(Pageable pageable): 페이징된 결과와 정렬된 결과를 조회합니다.

    1. findAll(Pageable pageable): 페이징된 엔티티를 조회합니다.

        Pageable pageable = PageRequest.of(0, 10); // 첫 번째 페이지에서 10개의 데이터를 가져옴
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);
        List<Employee> employees = employeesPage.getContent(); // 실제 데이터 목록

    2. findAll(Sort sort): 정렬된 엔티티를 조회합니다.

        Sort sort = Sort.by(Sort.Direction.ASC, "name"); // 'name' 필드로 오름차순 정렬
        List<Employee> employees = employeeRepository.findAll(sort);

    3. findAll(Pageable pageable): 페이징된 결과와 정렬된 결과를 조회합니다.

        Pageable pageable = PageRequest.of(0, 10, Sort.by("name")); // 첫 번째 페이지에서 'name' 필드로 정렬된 10개의 데이터를 가져옴
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);
        List<Employee> employees = employeesPage.getContent(); // 실제 데이터 목록


3. 커스텀 쿼리 메서드
메서드 이름으로 쿼리를 정의할 수 있는 메서드들입니다.

        findBy[Field](...): 필드 값으로 엔티티를 조회합니다.
        findTopBy[Field](...): 특정 필드 값으로 가장 첫 번째 엔티티를 조회합니다.
        countBy[Field](...): 필드 값으로 엔티티의 수를 셉니다.
        deleteBy[Field](...): 필드 값으로 엔티티를 삭제합니다.

4. 존재 여부 확인 메서드
특정 조건에 맞는 엔티티가 존재하는지 확인하는 메서드들입니다.

        existsBy[Field](...): 특정 필드 값으로 엔티티가 존재하는지 확인합니다.


5. 그 밖에 메서드 쿼리가 불가능한 쿼리는 @Query 어노테이션으로 작성하기

 */