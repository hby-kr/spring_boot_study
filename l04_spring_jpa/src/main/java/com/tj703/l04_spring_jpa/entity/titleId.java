package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class titleId implements Serializable {

    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "from_date", nullable = false)
    LocalDate fromDate;


}
