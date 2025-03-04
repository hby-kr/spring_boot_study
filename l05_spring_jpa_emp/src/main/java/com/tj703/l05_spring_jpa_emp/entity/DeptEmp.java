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

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // @ManyToOne, 현재 기준에서 무슨 조인을 하게 되는지
    //+ 조인의 방식을 fetch로 하겠다고 쓰는 것. 또한 fetch가 기본 조인방식으로 추천된다.
    @JoinColumn(name = "emp_no", nullable = false) // 현재 기준에서 무슨 컬럼명으로 조인하게 되는지
    private Employee empNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_no", nullable = false)
    private Department deptNo;

}