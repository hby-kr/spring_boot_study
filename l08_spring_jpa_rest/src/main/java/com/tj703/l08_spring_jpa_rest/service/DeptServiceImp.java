package com.tj703.l08_spring_jpa_rest.service;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import com.tj703.l08_spring_jpa_rest.entity.DeptEmpId;
import com.tj703.l08_spring_jpa_rest.entity.Employee;
import com.tj703.l08_spring_jpa_rest.repository.DeptEmpRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DeptServiceImp implements DeptService {

    private final DeptEmpRepository deptEmpRepository;
    private final EntityManager entityManager; // 영속성 컨텍스트 관리; 이미 조회했던 데이터를 캐시로 저장하는 것
    // 쓰는 이유 1. ; 가지고 있다가 필요할 때 쉽게 가져다 쓸 수 있음. 또 db에 접속할 필요가 없음
    // 쓰는 이유 2. ; 일의 묶음(트랜잭션) 관리를 안전하고 효율적으로 할 수 있음

    @Override
    // @Transactional // 지연 조회일 때, 조회의 마지막은 view에서 조회가 끝나기 때문에 Transactional를 쓰지 않아도 된다.
    public List<DeptEmp> readByEmpNo(int empNo) { return deptEmpRepository.findByEmpNo(empNo); }

    @Override
    @Transactional // 하나의 실행단위를 묶는 것. save나 remove는 이 한 메서드에서 끝이나므로 Transactional를 쓴다.
    public DeptEmp save(DeptEmp deptEmp) {
        return deptEmpRepository.save(deptEmp);
    }

    @Override
    @Transactional
    public void remove(DeptEmpId deptEmpId) { deptEmpRepository.deleteById(deptEmpId);}


    @Override // 등록만 하는 메서드
    @Transactional // 영속성 컨텍스트를 쓰려면 꼭 트랜잭션 단위로 실행해야 한다.
    public void register(DeptEmp deptEmp) {

        DeptEmpId deptEmpId = new DeptEmpId();
        deptEmpId.setEmpNo(deptEmp.getEmpNo());
        deptEmpId.setDeptNo(deptEmp.getDeptNo());

        DeptEmp existDeptEmp = entityManager.find(DeptEmp.class, deptEmpId);
        // find(Class<T> entityClass, Object primaryKey):  지정된 기본 키로 엔티티를 조회합니다.

        if (existDeptEmp != null) {
            throw new IllegalArgumentException("이미 부서이동 내역이 존재합니다.");
            // IllegalArgumentException ; 객체(생성, 파라미터)가 뭔가 문제가 있어서 발생하는 오류
            // 여기서는 객체가 이미 존재하고 있어서 오류.
        }
        entityManager.persist(deptEmp); // 매개변ㅅ수로 새로운 객체를 참조해야함
        // persist;  영속성 컨텍스트에 새로운 객체를 저장하면, 트랜젝션이 종료되었을 때 db에 저장
        // 엔티티를 영속 상태로 만듭니다. 엔티티가 데이터베이스에 삽입됩니다.

    }
    /*  EntityManager의 주요 메서드
        persist(Object entity):
            엔티티를 영속 상태로 만듭니다. 엔티티가 데이터베이스에 삽입됩니다.

        find(Class<T> entityClass, Object primaryKey):
            지정된 기본 키로 엔티티를 조회합니다.

        merge(Object entity):
            엔티티 상태를 영속성 컨텍스트로 병합합니다. 기존 데이터를 업데이트합니다.

        remove(Object entity):
            엔티티를 영속성 컨텍스트에서 제거하고 데이터베이스에서 삭제합니다.

        createQuery(String qlString):
            JPQL 쿼리를 생성합니다.

        getTransaction():
            현재 트랜잭션을 반환합니다.
     */

}
