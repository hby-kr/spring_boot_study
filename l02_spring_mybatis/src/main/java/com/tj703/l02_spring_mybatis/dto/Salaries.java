package com.tj703.l02_spring_mybatis.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Data
public class Salaries {
    private int empNo;
    private int salary;
    private LocalDate fromDate;
    private LocalDate toDate;

}
