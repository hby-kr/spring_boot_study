package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@Table(name = "employees") // employee라고 지었으니까 연결시켜주는 것
public class Employee implements Serializable {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    // 조인 해보기
    // 조인 관계를 적기.  salary에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것
    // @Transient // employee를 조회해서 영속성 컨텍스트에 저장할 때, Salary는 영속성 컨텍스트에 저장에서 제외하겠다. == fetch 안하겠다.
    // CascadeType.ALL: 모든 작업(영속, 병합, 제거, 새로 고침, 분리)을 연관된 엔터티에도 적용합니다. emp 저장,수정,삭제할 때 salaries도 똑같이 하겠다.
    // CascadeType.PERSIST: 엔터티를 영속성 컨텍스트에 추가할 때 연관된 엔터티도 함께 추가합니다. emp 저장할 때 salaries도 같이 저장하겠다.
    // CascadeType.MERGE: 엔터티를 병합할 때 연관된 엔터티도 함께 병합합니다.  emp 수정할 때 salaries도 같이 수정하겠다.
    // CascadeType.REMOVE: 엔터티를 삭제할 때 연관된 엔터티도 함께 삭제합니다. emp 삭제할 때 salaries도 같이 삭제하겠다.
    // CascadeType.REFRESH: 엔터티를 새로 고침할 때 연관된 엔터티도 함께 새로 고침합니다.
    // CascadeType.DETACH: 엔터티를 영속성 컨텍스트에서 분리할 때 연관된 엔터티도 함께 분리합니다.
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // == Salary.employee
    @OrderBy (value = "salary desc") // 인덱스가 없는 Set으로 자료를 받아도 순서 정렬해주기.
    private List<Salary> salaries=new ArrayList<>();// = new LinkedHashSet<>();
    // LinkedHashSet (순서를 보장하는 Set. List처럼 사용가능) (cf. HashSet은 인덱스없고 중복제거)
    // 기준잡기.
    // 조인을 많이 안하면, List타입으로 해도 됨.
    // JPA에서 조인을 하면 Set타입으로 해서 LinkedHashSet을 사용해야 하고

    // 조인 해보기
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // == Salary.employee
    private List<Title> Titles=new ArrayList<>();// = new LinkedHashSet<>() ;
    // 조인 관계를 적기.  title에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것

    // 조인 해보기
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // == Salary.employee
    private List<DeptEmp> deptEmps=new ArrayList<>();//= new LinkedHashSet<>() ;
    // 조인 관계를 적기.  title에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것



}