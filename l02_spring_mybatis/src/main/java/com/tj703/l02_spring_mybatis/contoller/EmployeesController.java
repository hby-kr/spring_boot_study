package com.tj703.l02_spring_mybatis.contoller;

import com.tj703.l02_spring_mybatis.dto.Employees;
import com.tj703.l02_spring_mybatis.service.EmployeesService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpResponse;

@RequestMapping("/emp")
@Controller
@AllArgsConstructor // 모든 필드를 파라미터로 가지는 생성자를 자동으로 생성
// @NoArgsConstructor //  파라미터가 없는 기본 생성자를 자동으로 생성
public class EmployeesController {

    private EmployeesService empService;

    @GetMapping("/readAll.do")
    public String readAll(Model model) {

        model.addAttribute("emps", empService.readAll());
        // 만약 오류가 뜨면
        // 1. 스프링 웹앱이 실행이 안됨
        // 2. 실행 후 서비스 호출 시 오류 -> 500
        // 3. null인 경우는 없고, 만약 db가 없으면 []을 반환
//        model.addAttribute("title", "사원상세 페이지");

        return "emp/readAll";
    }

    @GetMapping("/read.do")
    public String read(Model model, @RequestParam int empNo) {

        model.addAttribute("emp", empService.read(empNo));
        model.addAttribute("title", "사원 상세정보");
        return "emp/read";
    }


    @GetMapping("/modify.do")
    public String modify(
            Model model,
            @RequestParam int empNo) {

        model.addAttribute("emp", empService.read(empNo));
        model.addAttribute("title", "사원 수정");

        return "emp/modify";
    }


    @PostMapping("/modify.do")
    public String modifyAction(
            Employees emp,
            RedirectAttributes ra) {
        // RedirectAttributes는 Spring MVC에서 사용되는 객체로, 리다이렉트 요청에서 플래시 속성(flash attributes)을 추가하는 데 사용

        boolean result = false;
        result=empService.modify(emp);
        ra.addAttribute("empNo", emp.getEmpNo());

        if (result) {
//            return "redirect:/emp/read.do" + emp.getEmpNo();
            return "redirect:/emp/read.do";
        } else {
//            return "redirect:/emp/modify.do?empNo=" + emp.getEmpNo();
            return "redirect:/emp/modify.do";
        }
    }



    @GetMapping("/register.do")
    public String register(Model model) {

        model.addAttribute("title", "사원 등록 양식");

        return "emp/register";
    }

    @PostMapping("/register.do")
    public String registerAction(
            Employees emp,
            RedirectAttributes ra,
            HttpServletResponse resp) throws Exception {
        boolean result = false;
        result=empService.register(emp);

        if (result) {
            ra.addAttribute("empNo", emp.getEmpNo());
            return "redirect:/emp/read.do";
        } else {
            return "redirect:/emp/register.do";
        }
    }

    @GetMapping("/remove.do")
    public String removeAction(
            @RequestParam int empNo,
            RedirectAttributes ra
    ){
        boolean result=false;
        result=empService.remove(empNo);
        if(result){
            return "redirect:/emp/readAll.do";
        }else{
            ra.addAttribute("empNo",empNo);
            return "redirect:/emp/modify.do";
        }
    }
}
