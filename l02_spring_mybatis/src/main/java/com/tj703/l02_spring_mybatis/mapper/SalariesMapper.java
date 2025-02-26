package com.tj703.l02_spring_mybatis.mapper;

import com.tj703.l02_spring_mybatis.dto.Salaries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalariesMapper {

    List<Salaries> findById(@Param("no") int empNo);
}
