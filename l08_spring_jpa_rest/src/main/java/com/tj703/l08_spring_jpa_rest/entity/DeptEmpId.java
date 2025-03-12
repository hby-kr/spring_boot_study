package com.tj703.l08_spring_jpa_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Embeddable // 이 엔티티 클래스가 다른 엔티티의 속성으로 포함될 때 적용
/*
cf. @Embeddable과 @Entity
@Entity: 데이터베이스에서 독립적인 엔티티로 매핑됩니다. 각 엔티티는 고유한 식별자(@Id)를 가지며, 테이블에 대응합니다.
@Embeddable: 독립적인 엔티티가 아니며, 다른 엔티티에 속하는 값 타입 객체입니다. 즉, @Embeddable 클래스 자체는 테이블에 매핑되지 않고, 포함되는 엔티티의 속성으로 저장됩니다.
 */
public class DeptEmpId implements Serializable {

    private static final long serialVersionUID = -5007790062757419121L;

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeptEmpId entity = (DeptEmpId) o;
        return Objects.equals(this.empNo, entity.empNo) &&
                Objects.equals(this.deptNo, entity.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }
    /*  equals()와 hashCode()가 필요한 이유
    equals() 메서드는 두 객체가 동일한지 비교하는 데 사용
    hashCode() 메서드는 객체의 해시값을 반환하며, 주로 컬렉션 프레임워크(예: HashSet, HashMap)에서 객체를 저장하고 검색할 때 사용됩니다.
    이 두 메서드는 객체 비교와 해시 기반 컬렉션에서의 효율적인 검색을 보장하는 데 필수적입니다.
    객체의 hashCode() 값을 사용하여 객체를 효율적으로 저장하고, equals()를 사용하여 중복을 확인
     */
}