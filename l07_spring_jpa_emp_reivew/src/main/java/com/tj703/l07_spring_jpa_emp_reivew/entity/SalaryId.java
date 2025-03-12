package com.tj703.l07_spring_jpa_emp_reivew.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Embeddable // == 복합키를 타입이다
public class SalaryId implements Serializable {
/*      implements Serializable 에 대하여
기본키가 int나 String이면 index로 사용하기 좋고, jpa에서 key값으로 사용하기도 좋다
반면 복합키를 사용하기 위해서 타입을 생성해야 할 경우, 사용하기 좋도록 직렬화(문자열을 변형하거나 해시코드화)를 생성할 수 있다.

직렬화란 객체나 데이터를 저장하거나 전송할 수 있는 형식으로 변환하는 과정
객체 지향 프로그래밍에서 객체는 메모리 상에 존재하는 데이터이므로
이를 파일이나 네트워크를 통해 저장하거나 다른 시스템과 교환하려면 데이터를 연속적인 바이트 스트림 형태로 변환해야 합니다.

1. 객체를 바이트 단위로 바꿔서 원하는 형태로 변경 ; 객체 -> 해시코드 으로 변환 (바이트 스트림 직렬화)
2. 객체의 필드를 문자열로 바꿔서 원하는 형태로 변경 ; 객체 -> json 으로 변환 (문자열 직렬화)



 */

    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "from_date")
    private LocalDate fromDate;


}
