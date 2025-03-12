package com.tj703.l07_spring_jpa_emp_reivew.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    // 객체기반 쿼리

    public enum Gender {M, F}

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    // @Column(name = "gender") 필드명과 db테이블의 컬럼명이 같으면, 쓸 필요 없음.
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "BirthDate")
    private LocalDate BirthDate;

    @Column(name = "hireDate")
    private LocalDate hireDate;


    // 조인 작업 시작
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // Employee 입장에서 봤을 때 1:n
    // mappedBy = "employee"  ;  salaries가 employee를 참조하고 있어.
    // fetch = FetchType.LAZY  ;
    // cascade = CascadeType.ALL  // 캐시가 수정되면 얘도 수정되도록 하겠다.
    Set<Salary> salaries = new LinkedHashSet<>();


}
