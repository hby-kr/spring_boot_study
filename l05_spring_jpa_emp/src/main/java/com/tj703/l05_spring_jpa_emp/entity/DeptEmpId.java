package com.tj703.l05_spring_jpa_emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DeptEmpId implements java.io.Serializable {
    private static final long serialVersionUID = -2229536351165150455L;

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;


}