package com.tj703.l08_spring_jpa_rest.repository;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import com.tj703.l08_spring_jpa_rest.entity.DeptEmpId;
import com.tj703.l08_spring_jpa_rest.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    List<DeptEmp> findByEmpNo(int empNo);
}
