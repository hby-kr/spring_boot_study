package com.tj703.l02_spring_mybatis.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Employees {

    public enum Gender {
        M, F
    }

    private int empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;

    private List<DeptEmp> deptEmps; // 1:n fk emp_no

    private List<Salaries> empSalaries; // 1:n fk emp_no

}