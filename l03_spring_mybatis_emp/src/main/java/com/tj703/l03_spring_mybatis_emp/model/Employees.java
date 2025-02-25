package com.tj703.l03_spring_mybatis_emp.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * employees
 */
@Data
public class Employees implements Serializable {
    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private char gender;
    private Date hireDate;
}