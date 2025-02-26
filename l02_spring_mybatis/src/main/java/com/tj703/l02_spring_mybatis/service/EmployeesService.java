package com.tj703.l02_spring_mybatis.service;

import com.tj703.l02_spring_mybatis.dto.Employees;

import java.util.List;

public interface EmployeesService {

    // service와 dao의 메서드 이름을 다르게 짓는 이유?
    // 여러가지 dao 메서드 서비스 하나에 종합해서 넣기 때문에
    // dao의 메서드와는 다른 이름으로 만든다.
    // Service: 비즈니스 로직을 포함하며, 여러 DAO를 조합하여 필요한 작업을 수행

    List<Employees> readAll(); // emp./list.do
    Employees read(int empNo); // /emp.detail.do?empNo=10001 &&  /emp.modify.do?empNo=10001

    boolean register(Employees employees); // emp./list.do
    boolean modify(Employees employees); // emp./list.do
    boolean remove(int empNo); // emp./list.do?empNo=10001

}
