package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;


@ToString
@Getter
@Setter
@Embeddable
public class TitleId implements Serializable {

    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "from_date", nullable = false)
    LocalDate fromDate;


}
