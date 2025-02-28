package com.tj703.l05_spring_jpa_emp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "departments", schema = "employees")
public class Department {
    @Id
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    @Column(name = "dept_name", nullable = false, length = 40)
    private String deptName;

    @OneToMany(mappedBy = "deptNo")
    private Set<DeptEmp> deptEmp;

    @OneToMany(mappedBy = "deptNo")
    private Set<DeptManager> deptManagers;

}