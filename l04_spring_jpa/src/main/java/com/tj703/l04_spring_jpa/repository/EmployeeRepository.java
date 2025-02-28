package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // select e from Employee e where e.lastName =
    List<Employee> findByLastName (String lastName);

    // 입사일로 사람 조회하기
    List<Employee> findByHireDate (LocalDate hireDate); // 매개변수의 타입은 엔터티의 필드와 같아야 한다(규칙)

    List<Employee> findByHireDateGreaterThan(LocalDate hireDateIsGreaterThan);

    // 메서드 쿼리가 불가능한 쿼리는 @Query 어노테이션으로 작성하기
    // SQL에서는 LIKE 연산자가 문자열에 사용되는데, JPA에서는 날짜 형식을 문자열로 변환하지 않는다.
    // 그런데 LIKE 연산자를 써서 하고 싶은 상태.
//    @Query ("SELECT e FROM Employee e WHERE cast(e.hireDate as string) LIKE concat(:hireDateStr, '%') ")
//    List<Employee> findByHireDateStartsWith(String hireDateStr);

    @Query ("SELECT e.id, e.birthDate FROM Employee e WHERE cast(e.hireDate as string) LIKE concat(:hireDateStr, '%') ")
    List<Object[]> findByHireDateStartsWith(String hireDateStr);
    


}

/*
>> 엔터티(Entity)
    == dto에 db테이블과의 이름 연결을 적어놓은 코드파일
    목적이 조금 다른데, DTO는 데이터 전송을 위한 객체이며, 엔티티는 데이터베이스 테이블과 매핑되는 영속성 관리 객체.
    JPA에서 엔터티(Entity)는 데이터베이스 테이블과 매핑되는 자바 클래스입니다.
    엔티티 클래스는 **@Entity**라는 어노테이션을 사용하여 선언됩니다.
    엔티티 객체는 **데이터베이스의 한 행(row)**을 표현합니다.

>> Repository
== dao인터페이스
    DAO 인터페이스에서는 데이터베이스 작업을 위한 메서드를 직접 정의해야 합니다. 이 메서드들은 구현체에서 실제로 SQL 쿼리나 영속성 작업을 처리합니다.
    반면, JPA Repository는 JpaRepository나 CrudRepository를 상속받으면 기본적인 CRUD 메서드가 자동으로 제공되므로, 명시적으로 메서드를 정의하지 않아도 대부분의 작업을 처리할 수 있습니다.
    엔티티에 대한 CRUD 작업을 추상화하는 인터페이스. 객체와 데이터베이스 간의 매핑을 자동으로 처리.
    자동으로 SQL을 생성하고, ORM을 사용하여 객체와 데이터베이스 간의 변환을 처리한다.
    cf.
    DAO:    UserDao는 JDBC를 사용하여 SQL 쿼리를 직접 작성하여 데이터를 저장/조회함.
    MyBatis Mapper:     UserMapper 인터페이스와 XML 매핑 파일을 통해 쿼리와 객체 간의 매핑을 처리함.

>> JPQL (Java Persistence Query Language)
    JPQL = 자바 객체 대상으로 쿼리
    쉽게 말해서, SQL과 비슷하지만, DB테이블이 아니라 자바 객체(엔티티)를 대상으로 쿼리를 작성하는 언어
        DB로 쿼리 만들기;     SELECT * FROM users WHERE name = 'John';
        JPQL로 쿼리 만들기;   SELECT u FROM User u WHERE u.name = 'John';
        (여기서 User는 **자바 클래스(엔티티)**이고, u는 그 클래스의 인스턴스를 나타냅니다.)


 */