package com.tj703.l08_spring_jpa_rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "dept_emp", schema = "employees")
@IdClass(DeptEmpId.class) // 식별자를 구성하는 클래스를 지정하는 데 사용
// @Embeddable과 @Entity를 직접적인 연결을 하는 것이 아니라 복합 키(Composite Key)를 정의할 때 사용되는 어노테이션
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


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn (name = "emp_no", insertable = false, updatable = false) // DeptEmp 기준에서 무슨 컬럼명으로 조인하게 되는지
    // insertable = false, updatable = false ; 조인할 때만 쓰이지, inset나 update할 때는 쓰이는 것이 아냐.
    @ToString.Exclude // ToString 메서드 동작할 때 employee 필드는 배제하라.
    @JsonBackReference // 객체를 문자열 json 형태로 바꾸는 것을 하지마라.
    private Employee employee;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dept_no", insertable = false, updatable = false) // DeptEmp 기준에서 무슨 컬럼명으로 조인하게 되는지
    // insertable = false, updatable = false ; 조인할 때만 쓰이지, inset나 update할 때는 쓰이는 것이 아냐.
    @ToString.Exclude // ToString 메서드 동작할 때 employee 필드는 배제하라.
//    @JsonBackReference // 객체를 문자열 json 형태로 바꾸는 것을 하지마라.
    private Department dept;

}