package com.tj703.l02_spring_mybatis.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DeptManager extends DeptManagerKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date fromDate;

    private Date toDate;

}