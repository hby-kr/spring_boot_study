package com.tj703.l08_spring_jpa_rest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "departments", schema = "employees")
//@JsonInclude(JsonInclude.Include.NON_NULL) // Jackson 라이브러리에서 제공하는 애너테이션으로, 직렬화 과정에서 null 값이 포함된 필드를 제외하도록 지시하는 역할.
public class Department {

    @Id
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    @Column(name = "dept_name", nullable = false, length = 40)
    private String deptName;

}