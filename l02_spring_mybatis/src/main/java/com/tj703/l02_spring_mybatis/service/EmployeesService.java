package com.tj703.l02_spring_mybatis.service;

import com.tj703.l02_spring_mybatis.dto.Employees;

import java.util.List;

public interface EmployeesService {
    /*   service와 dao의 메서드 이름을 다르게 짓는 이유?

         DAO(Data Access Object) 데이터베이스와의 상호작용을 담당합니다.
         주로 데이터베이스 CRUD(Create, Read, Update, Delete) 작업을 수행합니다.
         dao의 메서드는
            save(): 새로운 엔티티를 데이터베이스에 저장
            findById(): 특정 ID로 엔티티 조회
            findAll(): 모든 엔티티 조회
            deleteById(): 특정 ID로 엔티티 삭제
            update(): 엔티티 업데이트

        Service 레이어는 비즈니스 로직을 담당합니다.
        DAO를 호출하여 비즈니스 규칙을 적용하거나, 여러 DAO를 조합하여 복합 작업을 수행합니다.
        service 파일 안 메서드 하나에 여러가지 dao 메서드 조합하여 하나의 서비스 로직을 구현하기 때문에
        Service: 비즈니스 로직을 포함하며, 여러 DAO를 조합하여 필요한 작업을 수행

        dao의 메서드와는 다른 이름으로 service의 메서드 이름을 만든다.
        Service의 메서드는
            createUser(): 새로운 사용자 생성
            getUserById(): 특정 ID로 사용자 정보 조회
            getAllUsers(): 모든 사용자 정보 조회
            deleteUser(): 특정 사용자 삭제
            updateUser(): 사용자 정보 업데이트

    이렇게 고수준 메서드는 비즈니스 로직을 담고, 저수준 메서드는 데이터베이스 작업을 직접적으로 수행

     */
    List<Employees> readAll(); // emp./list.do

    Employees read(int empNo); // /emp.detail.do?empNo=10001 &&  /emp.modify.do?empNo=10001

    boolean register(Employees employees); // emp./list.do

    boolean modify(Employees employees); // emp./list.do

    boolean remove(int empNo); // emp./list.do?empNo=10001

}
