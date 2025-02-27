package com.tj703.l02_spring_mybatis.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

@Data
public class Titles  {

    private int empNo;
    private String title;
    LocalDate fromDate;
    LocalDate toDate;
}