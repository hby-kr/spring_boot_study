package com.tj703.l01spring_web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

// lombok 사용해보기 ; 개발툴에 설치된 롬복 플러그인이 get,set을 자동완성
@Getter
@Setter
@ToString
public class UserDto {
    private String name;
    private int age;
    private String id;
    private String address;
    private String phone;
    private String pw;
    private boolean isMarried;
    private LocalDate birthday; // 기본값은 2025-03-24
}
