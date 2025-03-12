package com.tj703.l07_spring_jpa_emp_reivew.controller;

import com.tj703.l07_spring_jpa_emp_reivew.entity.Employee;
import com.tj703.l07_spring_jpa_emp_reivew.repository.EmpRepository;
import com.tj703.l07_spring_jpa_emp_reivew.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
@AllArgsConstructor
public class EmpController {

    private final EmployeeService employeeService;
    private final EmpRepository empRepository;

    @GetMapping("/readAll.do")
    public String readAll(
            Model model,
            @RequestParam(defaultValue = "1") int page) { // page번호가 없는 경우도 있으니까 defaul값 설정하기

        Pageable pageable = PageRequest.of(page - 1, 10); // 0번부터 시작이므로 -1
        Page<Employee> pageEmp = employeeService.readAll(pageable);
        model.addAttribute("pageEmp", pageEmp);

        return "emp/readAll";
    }
}
/*      pageable 객체의 구조

"pageable": {
    "pageNumber": 9,
    "pageSize": 10,
    "offset": 90,
    "unpaged": false,
    "paged": true
    },
"last": false,
"totalPages": 30003,
"totalElements": 300025,
"first": false,
"size": 10,
"number": 9,
"sort": {
"empty": true,
"unsorted": true,
"sorted": false
},
"numberOfElements": 10,
"empty": false

*/