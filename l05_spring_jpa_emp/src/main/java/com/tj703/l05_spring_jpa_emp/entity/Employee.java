package com.tj703.l05_spring_jpa_emp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "employees", schema = "employees")
public class Employee {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    //@Lob = 엔터티 클래스의 속성 중에서 큰 바이너리 데이터나 큰 문자열 데이터를 데이터베이스에 저장할 때 사용
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @OneToMany(mappedBy = "empNo")
    private Set<DeptEmp> deptEmps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "empNo")
    private Set<DeptManager> deptManagers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "empNo")
    private Set<Salary> salaries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "empNo")
    private Set<Title> titles = new LinkedHashSet<>();

}