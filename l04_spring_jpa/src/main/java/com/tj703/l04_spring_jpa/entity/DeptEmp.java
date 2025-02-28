package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpId.class)
public class DeptEmp {

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no") // DeptEmp 기준에서 무슨 컬럼명으로 조인하게 되는지
    @ToString.Exclude // ToString 메서드 동작할 때 employee 필드는 배제하라.
    @JsonBackReference // 객체를 문자열 json 형태로 바꾸는 것을 하지마라.
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "emp_no")
    @ToString.Exclude // ToString 메서드 동작할 때 employee 필드는 배제하라.
    @JsonBackReference // 객체를 문자열 json 형태로 바꾸는 것을 하지마라.
    private Employee employee;

}
