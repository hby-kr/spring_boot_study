package com.tj703.l02_spring_mybatis.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * dept_manager
 */
@Data
public class DeptManagerKey implements Serializable {
    private Integer empNo;

    private String deptNo;

    private static final long serialVersionUID = 1L;
}