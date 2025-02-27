package com.tj703.l02_spring_mybatis.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Data
@Alias("Salaries")
/* @Alias는 Lombok 라이브러리에서 제공하는 애노테이션 중 하나로, 클래스나 필드의 이름을 변경할 수 있도록 해줍니다.
 이 애노테이션을 사용하면 코드의 가독성을 높이고, 특정 상황에서 클래스나 필드의 이름을 원하는 대로 변경할 수 있습니다.  */
public class Salaries {
    private int empNo;
    private int salary;
    private LocalDate fromDate;
    private LocalDate toDate;

}
