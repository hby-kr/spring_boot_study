package com.tj703.l07_spring_jpa_emp_reivew.service;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Employee;
import com.tj703.l07_spring_jpa_emp_reivew.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // 롬복 어노테이션. 필드를 생성자에서 초기화.
public class EmployeeServiceImp implements EmployeeService {


    private final EmpRepository empRepository;
    // 아래의 생성자 안쓰고 롬복 어노테이션으로  @AllArgsConstructor
//    public EmployeeServiceImp(EmpRepository empRepository) {
//        this.empRepository = empRepository;
//    }

    @Override
    public Page<Employee> readAll(Pageable pageable) {
        return empRepository.findAll(pageable);
    }

    @Override
    public Employee readOne(int empNo) {
        return empRepository.findById(empNo);
    }

    @Override
    @Transactional // 수정,삭제,등록 등은 쓸 필요가 있다. == 커밋을 실패하면 롤백하겠다.
    public void remove(Employee employee) {
        empRepository.delete(employee);

    }

    @Override
    @Transactional // 수정,삭제,등록 등은 쓸 필요가 있다. == 커밋을 실패하면 롤백하겠다.
    public void save(Employee employee) {
        empRepository.save(employee);
    }
}
