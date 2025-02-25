package com.tj703.l02_spring_mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // @SpringBootTest // 필수로 기입해야 함. == 테스트할 때 스프링부트의 컨테이너의 객체를 사용할 수 있게 해준다.
class DepartmentMapperTest {

    @Autowired
    DepartmentMapper deptmapper;

    @Test
    void findAll() {
        System.out.println(deptmapper.findAll());
    }
}