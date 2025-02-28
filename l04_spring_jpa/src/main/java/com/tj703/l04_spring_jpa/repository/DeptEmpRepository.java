package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.DeptEmp;
import com.tj703.l04_spring_jpa.entity.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    List<DeptEmp> findByEmpNo(int empNo);
    List<DeptEmp> findByDeptNo(String deptNo);
}
