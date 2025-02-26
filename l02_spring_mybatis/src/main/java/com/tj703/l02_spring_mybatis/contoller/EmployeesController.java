package com.tj703.l02_spring_mybatis.contoller;

import com.tj703.l02_spring_mybatis.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/emp")
@Controller
@AllArgsConstructor
public class EmployeesController {

    private EmployeesService empService;

    @GetMapping("/readAll.do")
    public String readAll(Model model) {

        model.addAttribute("emps", empService.readAll());
        // 만약 오류가 뜨면
        // 1. 스프링 웹앱이 실행이 안됨
        // 2. 실행 후 서비스 호출 시 오류 -> 500
        // 3. null인 경우는 없고, 만약 db가 없으면 []을 반환
        // 4.

        return "emp/readAll";
    }

    @GetMapping("/read.do")
    public String read(Model model, @RequestParam int empNo) {

        model.addAttribute("emp", empService.read(empNo));

        return "emp/read";
    }

}
