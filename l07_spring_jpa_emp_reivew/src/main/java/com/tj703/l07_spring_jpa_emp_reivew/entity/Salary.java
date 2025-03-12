package com.tj703.l07_spring_jpa_emp_reivew.entity;

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
@Table(name = "salaries") // 엔터티 클래스와 db테이블 연결해주기
@IdClass(SalaryId.class) // 테이블이 복합키일 경우 따로 클래스타입 만들고, 연결해주기
public class Salary {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    // @Column (name = "salary") // 이름이 같으니까 안써도 됨
    private int salary;

    @Column(name = "to_date")
    private LocalDate toDate;


    // 조인 작업 시작
    // salary 입장에서 생각했을때 적어보면
    @ManyToOne(fetch = FetchType.LAZY)// n:1이므로. // 조인 방식을 명시해준다. (디폴트는 eager join)
    // lazy= 필요할 때 한다. 필요할 때란 trigger가 작동하는 때인데, 필드참조, tostring, jsonparsing 등이 있다.
    @JoinColumn(name = "emp_no") // join할 때 겹쳐지는, 참조키의 컴럼명을 명시해주는 것
    @ToString.Exclude // == salary 메서드에서 데이터를 불러올 때, employee도 같이 불러올 필요없다
    @JsonBackReference // == salary 메서드에서 데이터를 불러올 때, employee도 같이 불러올 필요없다
    private Employee employee;

}
