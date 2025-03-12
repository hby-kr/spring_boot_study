package com.tj703.l08_spring_jpa_rest.controller;

import com.tj703.l08_spring_jpa_rest.entity.Employee;
import com.tj703.l08_spring_jpa_rest.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/emp")
@AllArgsConstructor
public class EmpController {

    private final EmpService empService;

    @GetMapping("/findAll.do")
    public String findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Employee> empPage = empService.readAll(pageable);
        model.addAttribute("empPage", empPage);
        return "emp/findAll";
    }


    @GetMapping("/{empNo}/detail.do")
    public String detail(
            Model model,
            @PathVariable int empNo
        // @PathVariable은 RESTful API에서, URL 경로의 일부를 메서드 매개변수에 매핑하는 데 사용
        // RESTful API에서 주로 URL 경로에 포함된 데이터를 (매개변수로 사용하기 위해) 추출할 때 사용
        // URL 경로에 포함된 데이터 여러개를 가져오고 싶으면, 각 매개변수 앞에 복수번 사용해서 쓰면 됨.
        // Spring 4.3 이상에서는 @PathVariable의 이름을 생략할 수 있음. 이 경우, 변수명은 경로 변수명과 일치해야함.
    ) {
        Optional<Employee> empOpt = empService.readOne(empNo);
        Employee emp = empOpt.get(); // get()은 Optional 객체에 값이 있을 때 그 값을 반환하는 메서드.
        if (emp != null) {
            model.addAttribute("emp", emp);
            return "emp/detail";
        } else {
            return "redirect:/emp/findAll.do";
        }
    }

}
