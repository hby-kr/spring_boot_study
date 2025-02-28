package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "titles")
@IdClass(titleId.class)
public class title {

    @Id
    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Id
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Id
    @Column(name = "from_date", nullable = false)
    LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    LocalDate toDate;

    @JoinColumn(name = "emp_no") // title기준에서 무슨 컬럼명으로 조인하게 되는지
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude // ToString 메서드 동작할 때 employee 필드는 배제하라.
    @JsonBackReference // 객체를 문자열 json 형태로 바꾸는 것을 하지마라.
    private Employee employee;

}
