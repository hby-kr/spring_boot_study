package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@ToString
@Getter
@Setter
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
    // @MapsId("empNo")  // 복합키일 때, empNo는 복합키의 empNo 필드를 참조( salaryID.empNo == employee.emp_no
    // insertable = false, updatabl n tchType.LAZY)
    // 조인하기 위한 관계를 서로 맺어주는 것
    // FetchType.EAGER ; 즉시 조회1개를 조회할 때는 join, 여러개일 때는 Select fetch형식으로 진행.
    // FetchType.LAZY  ; 지연조회. 무조건 Select fetch형식으로 진행. 트리거가 발동할 때만 진행
    //    // 지연조회는 마지막 부분에서 트리거를 검사해서, 있으면 실행, 없으면 안 실행.
    // 필드를 참조하는 트리거는? ; 필드참조, toString, 직렬화(Json)(파일변환하기)
    // @Test  테스트에서 fetch 트리거인 toString을 발동시키면, 잘 인식을 못한다.
    // => @transactional을 정의해서, 테스트가 마지막 조회장소라는 것을 인식시켜주는 방식을 쓸 수 있다.
    // == 부모필드가 toString되면, 자식도 toString를 호출한다. 그것을 막는 것.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", insertable = false, updatable = false) // salary기준에서 무슨 컬럼명으로 조인하게 되는지
    @ToString.Exclude  // toString 메서드가 발동할 때, employee는 제외하겠다.
    @JsonBackReference
    private Employee employee;
}
