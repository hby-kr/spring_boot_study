package com.tj703.l05_spring_jpa_emp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "titles", schema = "employees")
public class Title {
    @EmbeddedId
    private TitleId id;

    @MapsId("empNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "emp_no", nullable = false)
    private Employee empNo;

    @Column(name = "to_date")
    private LocalDate toDate;

}