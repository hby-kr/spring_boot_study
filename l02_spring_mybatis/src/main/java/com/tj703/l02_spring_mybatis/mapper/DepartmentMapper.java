package com.tj703.l02_spring_mybatis.mapper;

import com.tj703.l02_spring_mybatis.dto.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // mybatis container에서 관리되는 객체 (mybatis = session factory)
public interface DepartmentMapper { // Mapper == Dao (Db access Object)

    List<DepartmentDto> findAll();


}
/*
MyBatis는 SqlSessionFactory라는 클래스를 사용하여 세션을 생성하고 관리합니다.
이를 통해 데이터베이스와의 상호작용을 간편하게 처리할 수 있습니다.

SqlSessionFactory는 MyBatis에서 SQL 세션(SqlSession)을 생성하는 역할을 합니다.
SqlSession은 데이터베이스에 대한 SQL 명령을 실행하고 트랜잭션을 관리하는 데 사용됩니다.

 */