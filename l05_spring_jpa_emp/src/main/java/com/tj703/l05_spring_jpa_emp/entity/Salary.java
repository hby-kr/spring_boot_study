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
@Table(name = "salaries", schema = "employees")
@IdClass(SalaryId.class)
public class Salary {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "emp_no", nullable = false)
//    // @OnDelete(action = OnDeleteAction.CASCADE)
//    private Employee empNo;

}