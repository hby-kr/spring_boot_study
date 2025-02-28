package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Embeddable
public class SalaryId implements java.io.Serializable {

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

}