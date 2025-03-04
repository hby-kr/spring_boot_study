package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column (name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    @Column (name = "dept_name", length = 40)
    private String deptName;

}
