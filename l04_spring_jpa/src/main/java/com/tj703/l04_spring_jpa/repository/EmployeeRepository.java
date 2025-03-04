package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);
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


    // fetch말고 그냥 join 해보기
    // @OneToMany 나 @ManyToOne으로 조회를 정의했을 때 강제로 조인하는 방법
    //@EntityGraph (attributePaths = {"salaries","titles"})
    //Employee findWithSalaryById(int id) ;
    /*
    jpa에서는 (효율적이고 합리적인?) fetch 방식을 기본 조인방식으로 여긴다.
    그러나 서비스 상황상 강제 조인을 해야할 필요가 있을 때,
    @EntityGraph라는 기능을 써서 강제조인을 시키기 위한 기능이다.

    1:n 조인을 한다는 것은 결과물의 행의 갯수가 곱하기 된다는 것을 뜻한다. 이럴 때 데이터의 중복이 계속 생길 것.
    fetch은 필요시에 그부분만 검색하는 거니까 중복이 생기지 않음.
    그러나 지금은 조인을 하려는 것. 그러면 중복을 없앨 수 있는 경우가 있을까? -> set 타입을 객체를 써라.

    @EntityGraph (attributePaths = {"salaries"})는 강제로 조인하는 것인데,
    그때 attributePaths의 값을 여럿 쓰면(=두개 이상 조인을 시키면), 계속해서 중복값이 나오게 될 것.
    그래서 Set타입으로 설정해놓지 않으면, 자바에서는 오류를 발생시켜 버린다.

    그런데 Set은 순서가 없잖아?
    @OrderBy (value = "salary desc") // 인덱스가 없는 Set으로 자료를 받아도 순서 정렬해주기.
    private Set<Salary> salaries = new LinkedHashSet<>();
     LinkedHashSet (순서를 보장하는 Set. List처럼 사용가능) (cf. HashSet은 인덱스없고 중복제거)
     기준잡기.
     조인을 많이 안하면, List타입으로 해도 됨.
     JPA에서 조인을 하면 Set타입으로 해서 LinkedHashSet을 사용해야 하고

     */



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