package com.example.l06_spring_jpa_emp_final.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "salaries")
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

    @JoinColumn(name = "emp_no") // salary기준에서 무슨 컬럼명으로 조인하게 되는지
    @ManyToOne (fetch = FetchType.LAZY)
    @ToString.Exclude // FetchType.LAZY의 트리거 off / 무한루프 방지.
    @JsonBackReference // Json객체를 만들 때(Json으로 직렬화 할 때) 해당필드를 참조하지 않는다. / 무한루프 방지.
    private Employee employee;
    // ManyToOne을 먼저 쓰고 그다음 OnetoMany를 쓸 것
}