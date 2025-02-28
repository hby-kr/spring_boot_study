package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employees") // employee라고 지었으니까 연결시켜주는 것
public class Employee {
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
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY) // == Salary.employee
    private List<Salary> salaries;
    // 조인 관계를 적기.  salary에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것

    // 조인 해보기
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY) // == Salary.employee
    private List<title> titles;
    // 조인 관계를 적기.  title에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것

    // 조인 해보기
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY) // == Salary.employee
    private List<DeptEmp> deptEmps;
    // 조인 관계를 적기.  title에서 @ManyToOne, @OneToOne을 구현하고 있어야 한다. 관계를 지어주는 것


}