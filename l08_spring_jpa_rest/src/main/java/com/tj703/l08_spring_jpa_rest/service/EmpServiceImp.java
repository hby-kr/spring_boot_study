package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.Employee;
import com.tj703.l08_spring_jpa_rest.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpServiceImp implements EmpService {

    private final EmployeeRepository empRepository;

    @Override
    public Optional<Employee> readOne(int empNo) {
        return empRepository.findById(empNo);
    }

    @Override
    public Page<Employee> readAll(Pageable pageable) {
        return empRepository.findAll(pageable);
    }
}
/*
Page 객체와 Pageable 객체는 다릅니다.
둘은 모두 Spring Data JPA에서 페이징 처리를 다룰 때 사용되지만, 그 역할과 목적은 다릅니다.


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  Page 객체
Page 객체는 페이징 처리된 실제 데이터 목록과 페이지 관련 메타데이터를 래핑(wrapping)하는(=담고 있는) 객체. 페이징된 "결과" 객체.
대용량 데이터를 한 번에 모두 가져오는 대신, 특정 페이지에 해당하는 데이터만 가져올 수 있도록 돕는 역할을 합니다.

Page 객체의 내용은 크게 둘인데
    페이징된 데이터: Page 객체는 요청된 페이지 번호와 페이지 크기에 해당하는 데이터를 포함.
    메타데이터 제공: Page 객체는 페이지네이션에 관련된 다양한 정보를 제공 예를 들어, 총 데이터의 개수, 총 페이지 수 등.

public class Page<T> {
    // 페이징 된 데이터
        private List<T> content;  // 페이징된 실제 데이터 (한 페이지에 해당하는 엔티티 리스트)
    // 메타테이터
        private long totalElements;  // 전체 데이터 개수
        private int totalPages;  // 총 페이지 수
        private boolean first;  // 첫 번째 페이지 여부
        private boolean last;  // 마지막 페이지 여부
        private int number;  // 현재 페이지 번호
        private int size;  // 페이지 크기 (한 페이지에 포함될 데이터 수)
}

ㅡㅡㅡㅡㅡㅡㅡ Page 객체에서 자주 사용되는 필수적인 메서드
ㅡ getContent() 메서드
    getContent() 메서드는 Page 객체와 관련된 메서드입니다. 이 메서드는 페이징 처리된 데이터를 List<T> 형태로 반환
    Page 객체 안에 있는 content 필드(실제 데이터 목록)의 값을 가져오는 메서드

ㅡ getTotalElements()
    전체 데이터의 총 개수를 Long 반환합니다. 즉, 페이징 처리 전 전체 엔티티의 개수를 알 수 있습니다.
ㅡ getTotalPages()
    전체 페이지 수를 int 반환합니다. totalElements와 pageSize(페이지 크기)를 기반으로 계산된 값. 전체 페이지 수를 확인할 때 사용
ㅡ getNumber()
    현재 페이지 번호를 int 반환합니다. 0-based 인덱스를 사용(= 첫 번째 페이지는 0). 현재 페이지 번호를 확인할 때 사용
ㅡ getSize()
    한 페이지에 포함된 데이터의 개수(페이지 크기)를 int 반환합니다. 페이지 크기를 확인할 때 사용.
ㅡ isFirst(), isLast()
    현재 페이지가 처음인지/마지막 페이지인지 여부를 반환합니다. 맞으면 true, 아니면 false.
ㅡ hasNext(): 다음 페이지가 있는지 여부를 boolean 반환
ㅡ hasPrevious(): 이전 페이지가 있는지 여부를 boolean 반환

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  Page 객체
Pageable은 페이지 번호, 페이지 크기, 정렬 정보 등을 담고 있는 객체. 페이징을 위한 "요청" 객체.

Pageable pageable = PageRequest.of(page - 1, size); // Pageable 객체는 요청할 페이지 번호와 크기를 설정

주요 역할:
페이지 번호: 요청한 페이지 번호(0부터 시작).
페이지 크기: 한 페이지에 포함될 데이터의 수.
정렬 정보(선택적): 페이지 내에서 데이터를 어떻게 정렬할지에 대한 정보.

Pageable 인터페이스는 일반적으로 PageRequest 클래스를 통해 구현됩니다.
PageRequest는 페이지 번호, 페이지 크기, 정렬 정보를 설정하여 Pageable 객체를 쉽게 생성할 수 있도록 돕습니다

                    PageRequest.of(int page, int size)
Pageable pageable = PageRequest.of(    0   ,    10   );  // 첫 번째 페이지, 한 페이지에 10개의 데이터
                    PageRequest.of(int page, int size, Sort sort)
Pageable pageable = PageRequest.of(0       , 10      , Sort.by("name").ascending());  // 이름을 기준으로 오름차순 정렬
Pageable pageable = PageRequest.of(0       , 10      , Sort.by(Direction.ASC, "name", "age")); // 기준이 복수일 때



 */










