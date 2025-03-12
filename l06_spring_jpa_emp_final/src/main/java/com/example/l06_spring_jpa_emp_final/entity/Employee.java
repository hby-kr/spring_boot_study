package com.example.l06_spring_jpa_emp_final.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
//@Data(=전체 다 구현)를 쓰면 그 안에 @EqualsAndHashCode 가 구현되어지므로 오류날 수도 있음
 /*   지연조회와 프록시 객채와 hashcode
 지연조회시 entity에 존재하지 않는(나중에 조회할) 필드가 있어서, 대리역할로 프록시 객체를 생성해서 조회에 사용한다.
 그때 만약 프록시 객체에서 존재하지 않는 필드를 조회하면, entity가 실제로 그 필드를 조회하는 것이 지연조회의 구현 형태이다.
 프록시는 entity를 부모객체로 사용하고 있지만, 서로 다른 객체이기 때문에 hashCode를 사용하는 것을 권장하지 않는다.
 또한 entity에 set필드가 있다면, Set에는 이미 hashCode가 구현되어 있기 때문에 또 정의하게 되면 문제가 발생할 수 있다.
 따라서 @Data가 아니라 @Getter @Setter @ToString를 각각 명시할 것
 */
@Entity
@Table(name = "employees")
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

    // @Formula는 하이버네이트(Hibernate)에서 제공하는 어노테이션으로, 엔티티의 속성 값을 데이터베이스 쿼리를 통해 계산하는 데 사용
    // 이를 통해 계산된 필드를 엔티티에 추가할 수 있으며, 데이터베이스에서 값을 가져올 때 자동으로 계산된 결과를 반환
    @Formula(value = "(SELECT de.dept_no FROM dept_emp de WHERE de.to_date > now() and de.emp_no = emp_no)")
    private String deptNoNow;


    // emp.getDeptEmp().getGender / 이것이 트리거가 되서 fetch_lazy로 찾기 시작
    // SELECT * FROM dept_emp WHERE emp_no = emp.empNo
    @OneToMany(mappedBy = "employee")
    private Set<DeptEmp> deptEmps = new LinkedHashSet<>();

    @OneToMany (mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Salary> salaries = new LinkedHashSet<>();



}