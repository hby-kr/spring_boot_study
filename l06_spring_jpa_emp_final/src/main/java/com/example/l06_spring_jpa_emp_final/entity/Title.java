package com.example.l06_spring_jpa_emp_final.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "titles")
public class Title {
    @EmbeddedId
    private TitleId id;

    @Column(name = "to_date")
    private LocalDate toDate;

}