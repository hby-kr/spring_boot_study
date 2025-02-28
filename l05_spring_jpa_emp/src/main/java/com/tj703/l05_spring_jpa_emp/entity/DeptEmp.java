package com.tj703.l05_spring_jpa_emp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "dept_emp", schema = "employees")
@IdClass(DeptEmpId.class)
public class DeptEmp {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Id
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @JoinColumn(name = "emp_no", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Employee empNo;

    @JoinColumn(name = "dept_no", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department deptNo;

}