package com.tj703.l08_spring_jpa_rest.controller;

import com.tj703.l08_spring_jpa_rest.entity.DeptEmp;
import com.tj703.l08_spring_jpa_rest.entity.DeptEmpId;
import com.tj703.l08_spring_jpa_rest.service.DeptService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
@AllArgsConstructor
public class DeptController {

    private final DeptService deptService;

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
    // Logger는 애플리케이션에서 로그 메시지를 기록하는 데 사용되는 객체
    // LoggerFactory는 개발자의 의도대로 로깅 시스템을 설정하고 로그를 출력하는 데 도움을 주는 객체.
    // DeptController 클래스에 대한 Logger 객체를 생성합니다.
    // 그런 다음, 각 로깅 레벨에 따라 로그 메시지를 기록합니다. 예외 발생 시에는 예외 정보와 함께 로그를 기록합니다.


    @GetMapping("/{empNo}/readEmp.do")
    @ResponseBody // 뷰를 랜더링하지 않고, 반환하는 객체(List)를 json으로 반환한다. -> Jackson 라이브러리 이용
    // http://localhost:8080/dept/10010/readEmp.do 직접 url쳐서 테스트해보기. html이 아닌 json을 반환할거임
    public List<DeptEmp> readEmp(@PathVariable int empNo) { // @PathVariable == path 중에서 매개변수로 받아올거임
        List<DeptEmp> deptEmpList = deptService.readByEmpNo(empNo);
        return deptEmpList;
    }


    @PostMapping("/deptEmp.do")
    @ResponseBody
    public ResponseEntity<DeptEmp> deptEmpRegister(@RequestBody DeptEmp deptEmp) {
        // ResponseEntity 객체 : 응답코드를 생성하고 dto를 같이 반환할 수 있는 객체. 응답의 상태 코드, 헤더, 바디를 모두 제어할 수 있음
        //      @ModelAttribute : 쿼리스트링을 객체로 파싱
        //      @RequestBody : json을 객체로 파싱

        try {
            deptService.register(deptEmp);
            return ResponseEntity.status(201).body(deptEmp); // status가 200인 상태에서 {dept:{...} } 가지고 반환
        } catch (IllegalArgumentException e) { // 이미 부서이동 내역이 존재하면 발생
            return ResponseEntity.status(409).body(null); // 저장하려는 데이터가 이미 존재 (클라이언트 잘못)
        } catch (DataIntegrityViolationException e) { // DataIntegrityViolationException = 참조키가 없을 때 오류
            return ResponseEntity.status(507).body(null);
            // 409 Conflict;  이 응답은 요청이 현재 서버의 상태와 충돌될 때
            // 507 : 저장실패 (그 중에서 현재는 참조할 키가 없음을 나태는 것)
        } catch (Exception e) { // 그밖에 알 수 없는 오류 잡는 그물.
            return ResponseEntity.status(500).body(null); //
        }
    }

    // GET: 리소스 달라 /  POST: 리소스 저장해 달라 (동기식 통신에서 가능)
    // DELETE: 리소스 삭제해 달라
    // PUT:
    @DeleteMapping("/deptEmp.do")
    // 삭제하려할 때 매개변수를 어떻게 보낼 것인가. 1 url로 보낸다. (rest API) / 2. json으로 보낸다. (RequestBody)
    public ResponseEntity<Void> removeDeptEmp(@RequestBody DeptEmpId deptEmpId) { // @RequestBody : json을 객체로 파싱
        logger.info(deptEmpId.toString());

        try {
            deptService.remove(deptEmpId);
            return ResponseEntity.status(202).build(); // 202: (여기서는) 비동기식으로 데이터가 처리되었음 ; 데이터가 비동기로 삭제됨
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).build();
            // 동적 리로스, db리소스가 없는 상태
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping("/register.do")
    public String register(
            @ModelAttribute DeptEmp deptEmp,
            //  @ModelAttribute : POST 방식으로 보내는 폼 데이터(즉, HTTP 요청 파라미터)를 자동으로 자바 객체로 맵핑,바인딩해주는 역할
            //  @RequestBody : json을 객체로 파싱
            // 매핑(mapping)은 데이터를 연결하는 과정으로, 데이터를 어떤 객체의 필드에 대응시키는 것이고,
            // 바인딩(binding)은 매핑을 통해 대응시킨 데이터를 실제 객체에 할당하는 과정입니다.
            RedirectAttributes redirectAttributes
            // 리다이렉트 후에, 클라이언트에게 데이터를 전달해야 할 경우에 사용
            // 예를 들어 폼 제출 후 성공/실패 메시지나 사용자 알림 등을 리다이렉트된 페이지에서 사용할 수 있도록 전달하기 위해 사용
            // 이 데이터는 리다이렉트가 완료된 후 1번의 요청 동안만 유효하게 유지됩니다. (addFlashAttribute)
            // 이를 통해 RedirectAttributes는 임시 데이터를 전달하는 용도로 활용.
    ) {
        //?empNo=10001&deptNo=d002&fromDate=2024-01-01&toDate=2025-01-01
        logger.info(deptEmp.toString());
        try {
            deptService.save(deptEmp);
        } catch (Exception e) {
            logger.error(e.getMessage());
            redirectAttributes.addFlashAttribute("msg", e.toString());
            // addFlashAttribute : session 처럼 내장 객체로 값을 전달 후 삭제 됨 (1회사용)
            // 어떤 데이터 타입이라도 가능합니다. 문자열, 객체 등 모든 자바 객체를 전달할 수 있습니다.
            // 데이터는 flash 영역에 저장되며, 리다이렉트된 요청에서만 사용할 수 있습니다.
            return "redirect:/emp/" + deptEmp.getEmpNo() + "/detail.do";
        }
        //redirectAttributes.addAttribute("empNo", deptEmp.getEmpNo()); => 쿼리스트링 ?empNo=10002
        redirectAttributes.addFlashAttribute("msg", "success");
        return "redirect:/emp/" + deptEmp.getEmpNo() + "/detail.do";
    }


}

/*
ㅡㅡㅡㅡㅡㅡㅡ  HTTP 상태 코드
1xx: 정보 응답
    100 Continue: 클라이언트가 요청을 계속할 수 있음을 의미합니다.
    101 Switching Protocols: 서버가 클라이언트의 프로토콜 전환 요청을 받아들였음을 의미합니다.

2xx: 성공 응답
    200 OK: 요청이 성공적으로 처리되었음을 의미합니다.
    201 Created: 요청이 성공적으로 처리되었고, 리소스가 생성되었음을 의미합니다.
    204 No Content: 요청이 성공적으로 처리되었지만, 반환할 내용이 없음을 의미합니다.

3xx: 리다이렉션 응답
    301 Moved Permanently: 요청한 리소스가 영구적으로 다른 URL로 이동했음을 의미합니다.
    302 Found: 요청한 리소스가 임시적으로 다른 URL로 이동했음을 의미합니다.
    304 Not Modified: 요청한 리소스가 변경되지 않았음을 의미합니다. 클라이언트는 캐시된 버전을 사용할 수 있습니다.

4xx: 클라이언트 오류 응답
    400 Bad Request: 클라이언트의 요청이 잘못되었음을 의미합니다.
    401 Unauthorized: 인증이 필요함을 의미합니다.
    403 Forbidden: 서버가 요청을 이해했으나, 권한이 없어 실행할 수 없음을 의미합니다.
    404 Not Found: 요청한 리소스를 찾을 수 없음을 의미합니다.

5xx: 서버 오류 응답
    500 Internal Server Error: 서버 내부에 오류가 발생했음을 의미합니다.
    501 Not Implemented: 서버가 요청된 기능을 지원하지 않음을 의미합니다.
    502 Bad Gateway: 게이트웨이 또는 프록시 서버에서 잘못된 응답을 받았음을 의미합니다.
    503 Service Unavailable: 서버가 일시적으로 과부하 또는 점검 중임을 의미합니다.

 */