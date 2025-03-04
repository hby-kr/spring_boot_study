package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Getter
@Setter
@Embeddable
public class DeptEmpId implements Serializable {

    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "dept_no")
    private String deptNo;

}
