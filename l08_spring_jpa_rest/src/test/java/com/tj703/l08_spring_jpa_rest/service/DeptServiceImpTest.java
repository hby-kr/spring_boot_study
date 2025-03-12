package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import com.tj703.l08_spring_jpa_rest.entity.DeptEmpId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptServiceImpTest {

    @Autowired
    DeptService deptService;

    @Test
    void save() { // jpa에서 미리 제공하는 메서드인 save는 없으면 등록, 있으면 수정된다.
        DeptEmp deptEmp = new DeptEmp();
        deptEmp.setEmpNo(10002);
        deptEmp.setDeptNo("d003");
        deptEmp.setFromDate(LocalDate.parse("2020-01-01"));
        deptEmp.setToDate(LocalDate.parse("2020-12-02"));
        deptService.save(deptEmp);
        // insertable = false, updatable = false // 엔터티에서 이 설정 해줘야 함
    }

    @Test
    void remove() {
        DeptEmpId deptEmpId = new DeptEmpId();
        deptEmpId.setEmpNo(10002);
        deptEmpId.setDeptNo("d003");
        deptService.remove(deptEmpId);
    }

    @Test
    void register() {
        // 더미 만들고
        DeptEmp deptEmp = new DeptEmp();
        deptEmp.setEmpNo(10007);
        deptEmp.setDeptNo("d003");
        deptEmp.setFromDate(LocalDate.parse("2024-02-01"));
        deptEmp.setToDate(LocalDate.parse("2024-04-01"));
        // 넣어서 테스트
        deptService.register(deptEmp);
    }
}