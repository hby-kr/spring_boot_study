package com.tj703.l02_spring_mybatis.service;

import com.tj703.l02_spring_mybatis.dto.Employees;
import com.tj703.l02_spring_mybatis.mapper.EmployeesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 트랜젝션에 특화되어 있는 컴포넌트
@AllArgsConstructor // 필드를 생성자로 초기화 // lombok의 기능  (1.Autowired  2. 생성자 만들기 3. AllArgsConstructor )
public class EmployeesServiceImp implements EmployeesService {

    // @Autowired  이렇게 불러올 수도 있지만
    private EmployeesMapper empMapper;
    // 생성자에 변수로 넣으면, @Autowired 안써도 됨
    // public EmployeesServiceImp(EmployeesMapper empMapper) { this.empMapper = empMapper;}


    @Override
    public List<Employees> readAll() {
        return empMapper.findAll();
        //        List<EmployeesDto> readAll = null;
        //        readAll = empMapper.findAll();
        //        return readAll;
        //이라고 쓰는 것과 같음
    }

    @Override
    public Employees read(int empNo) {
        return empMapper.findById(empNo);
    }

    @Override
    public boolean register(Employees employees) {
        return empMapper.insert(employees) > 0;
    }

    @Override
    public boolean modify(Employees employees) {
        return empMapper.update(employees) > 0;
    }

    @Override
    public boolean remove(int empNo) {
        return empMapper.delete(empNo) > 0;
    }

}

