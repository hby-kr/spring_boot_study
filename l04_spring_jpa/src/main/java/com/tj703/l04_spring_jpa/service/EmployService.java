package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployService {

    private final EmployeeRepository empRepository;
    private final EntityManager entityManager;
    // EntityManager 영속성 컨텍스트의 엔터티를 호출




    @Transactional
    public void entityManagerTest() {
        // 1. 비영속 상태 (Transient):  (Transient: 일시적인, 순간적인)

        // 2. 영속 상태 (Persistent):
        Optional<Employee> findEmpOpt = empRepository.findById(10001);
        //System.out.println(findEmpOpt); // 얘가 오류의 원인이었음.
        Employee entityEmp = entityManager.find(Employee.class, 10001);
        // 영속성 컨테이너에 10001번 있어? 있으면 있는 것을 그냥 반환, 없으면 찾아서 보여줌
        System.out.println(findEmpOpt.get() == entityEmp);
        // 처음 한번만 찾고, 영속성 컨테이너에 저장된 객체를 반환한다.

        // 혹시 또 한번 불러오면?
        Optional<Employee> findEmpOpt2 = empRepository.findById(10001);
        System.out.println(findEmpOpt.get() == findEmpOpt2.get()); // true  = 같은 것을 불러오고 있다는 것.
        System.out.println(findEmpOpt.get() == entityEmp); // true  = 같은 것을 불러오고 있다는 것.
        // 영속성 컨테이너 덕분에 DB와 매번 Connection을 생성(통신)하지 않기 때문에 부담이 적다.


        // 기존이 데이터를 수정 후 EntityManager.persist()로 유지 시키면 내열이 수정됨(update)
        entityEmp.setBirthDate(LocalDate.parse("2025-03-04"));
        entityManager.persist(entityEmp);

        // 새로운 데이터를 생성 후 persist()하면 insert한다.
        Employee emp = new Employee();
        emp.setId(111);
        emp.setBirthDate(LocalDate.parse("2025-03-04"));
        emp.setGender("M");
        emp.setFirstName("Joe");
        emp.setLastName("Smith");
        emp.setHireDate(LocalDate.parse("2025-03-04"));
        entityManager.persist(emp); // 두번 넣으면 오류남
//        merge(저장된entity) ;
//          udpate 또는 delete로 스키마에 저장된 내역과 영속성 컨텍스트에 등록된 내역을 동일하게 만듬. 영속성 컨텍스트에 없는 엔터티를 병합하여 저장
//        detach(저장된entity) ; 영속성 컨텍스트에 저장된 엔터티를 삭제
//        clear() :  완전히 초기화
    }


    public void modifyEmpSaveSalariesAndTitles(Employee emp) {
        // 그냥 modify할거면 save사용. 찾아서 있으면 수정, 없으면 등록
        empRepository.save(emp);
        // save 안쓰면, 직접 find()로 찾아서, if문으로 null이면, persist() 등록, null아니면 persist() 수정





    }

}
/*
jPA란 Java Persistence API

영속성(Persistence)은 JPA에서 엔터티 객체를 데이터베이스에 지속적으로 저장하고 관리하는 것을 의미

JPA의 영속성 컨테이너(Persistence Context); 엔터티(Entity) 객체들을 관리하는 중간 계층
영속성 컨텍스트(Persistence Context): 엔터티 인스턴스의 생명 주기를 관리하는 JPA의 핵심 개념

영속성 컨테이너는 데이터베이스와 객체 간의 상태 변화를 관리하며, 영속성 컨텍스트 내의 엔터티 인스턴스들은 "영속 상태"를 유지

영속성 컨텍스트는 이전 검색 내역을 저장하는 것이 아니라, 애플리케이션이 실행되는 동안 엔터티 객체의 상태를 관리하는 역할
애플리케이션이 실행되는 동안 엔터티 객체를 메모리에서 관리하고, 데이터베이스와의 상태 변화를 추적하는 것
트랜잭션이 끝나면 영속성 컨텍스트도 사라지기 때문에 이전 검색 내역을 따로 저장해서 가지고 있는 것은 아닙니다
    트랜잭션(Transaction)은 데이터베이스 작업에서 일련의 작업을 하나의 단위로 묶는 것



>> 영속성 컨텍스트(Persistence Context)에서 엔터티는 다양한 상태를 가질 수 있습니다
이 상태들을 통해 JPA는 엔터티의 생명 주기를 관리하며, 데이터베이스와의 일관된 상태를 유지할 수 있습니다.

1. 비영속 상태 (Transient):
    엔터티가 새로 생성되었지만 아직 영속성 컨텍스트에 추가되지 않은 상태
    데이터베이스와 연관되지 않았기 때문에, 트랜잭션이 끝나면 사라집니다.
    Person person = new Person(); // 비영속 상태

2. 영속 상태 (Persistent):
    엔터티가 영속성 컨텍스트에 추가되어 데이터베이스와 동기화된 상태입니다.
    엔터티 관리자를 통해 추가된 엔터티로, 변경 사항은 자동으로 데이터베이스에 반영됩니다.
    em.persist(person); // 영속 상태

3. 준영속 상태 (Detached):
    엔터티가 영속성 컨텍스트에서 분리된 상태입니다.
    여전히 메모리에 존재하지만 영속성 컨텍스트에서 관리되지 않습니다.
    데이터베이스와 더 이상 동기화되지 않으며, 필요 시 다시 영속성 컨텍스트에 추가해야 합니다.
    em.detach(person); // 준영속 상태

4. 삭제 상태 (Removed):
    특정 엔터티를 영속성 컨텍스트에서 삭제. 엔터티가 영속성 컨텍스트에서 제거된 상태입니다.
    데이터베이스에서도 삭제되며, 트랜잭션이 커밋될 때 실제로 데이터베이스에서 삭제됩니다.
    em.remove(person); // 삭제 상태

5. clear() 메서드
    JPA에서 영속성 컨텍스트를 초기화하는 데 사용됩니다.
    영속성 컨텍스트에 존재하는 모든 엔터티를 비영속 상태로 만들어 엔터티 관리자(Entity Manager)와의 관계를 끊습니다.
    즉, clear() 메서드를 호출하면 영속성 컨텍스트가 관리하던 엔터티들이 더 이상 영속성 컨텍스트에 의해 관리되지 않게 됩니다.
    em.clear();  // 영속성 컨텍스트 초기화

 */
