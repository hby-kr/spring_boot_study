package com.tj703.l01spring_web.controller;

import com.tj703.l01spring_web.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
// @Component의 자식으로 Servelt 클래스
public class HomeController {

    @GetMapping("/") // http://localhost:8181/라고 get 방식 요청오면
    // 물론 이것은 디폴트 값임. 그냥 설정해본것
    public String home() {
        return "index"; // 이것을 반환하라.
    }
    // 타임리프(Thymeleaf)를 사용하는 경우
    // 접두사 prefix:  classpath:/templates/
    // 접미사 suffix: .html
    // (세팅을 다르게 할수도 있음)
    // return "index"라고 문자열을 반환하면
    //          prefix       + index + suffix 를 알아서 붙여준다.
    // classpath:/templates/ + index + .html
    /*
    classpath:/static/ — src/main/resources/static/ 경로의 리소스를 참조합니다.
    classpath:/templates/ — src/main/resources/templates/ 경로의 템플릿 파일을 참조합니다.
    /WEB-INF/views/ — src/main/webapp/WEB-INF/views/ 폴더에 위치한 JSP 파일을 참조합니다.
    스프링은 classpath: 접두어를 사용하여 src/main/resources 디렉토리 내의 리소스를 참조합니다.
    예를 들어, classpath:/templates/는 실제 파일 시스템에서 src/main/resources/templates/ 경로를 가리키는 것입니다.
     */


    // 한 서블릿 안에 주소를 여러개 설정할 수 있다는 것도 특징임
    // 톰킷에서는 서블릿 매핑 1:1로 각 java파일을 만들었다면,
    // 하나의 맵핑이 하나의 메서드가 되어서 실행되게 함 -> 따라서 여러 메서드(여러 매핑)을 한번에 적을 수 있음
    @GetMapping("/sum.do")
    public String sum(@RequestParam(defaultValue = "0") int a,
                      @RequestParam(defaultValue = "0") int b,
                      // @RequestParam(defaultValue = "0")는 기본값 세팅하는 것. RequestParam을 쓰면 자동으로 required=true가 설정되고, 없으면 400에러. 파라미터가 없으면 페이지가 동작하지 않는다.
                      Model model) {
        // Model ; Model 객체는 랜더링할 뷰가 지정되어 있을 때 사용하며, 컨트롤러에서 뷰로 데이터를 전달하는 데 사용
        // 뷰에서 필요한 데이터를 설정할 수 있으며, 이를 통해 뷰 템플릿(예: JSP, Thymeleaf 등)에서 데이터를 렌더링할 수 있음  cf. ModelAndView
        model.addAttribute("sum", a + b);
        // == request.setAttribute("sum", a+b)  // sum라는 속성으로 a + b의 값을 뷰 템플릿에 전달
        return "sum"; // veiw인 sum.html으로 보내면서 model객체 "sum"을 함께 보냄.
        // req.getRequestDispatcher("/WEB-INF/views/sum.do").forward(req, resp); 이와 같은 명령임
    }
    /*  Model 메서드
        addAttribute(String attributeName, Object attributeValue): 모델에 속성을 추가합니다.
        addAttribute(Object attributeValue): 모델에 익명 속성을 추가합니다.(주로 클래스를 모델 안에 넣고, 호출하 때는 객체.필드 방식으로 호출)
        mergeAttributes(Map<String, ?> attributes): 모델에 여러 속성을 추가합니다.
        containsAttribute(String attributeName): 모델에 특정 속성이 존재하는지 확인합니다.
     */


    // 컨트롤러 내부에서 작성된 함수 서블릿(mult.do)은 매개변수로, 스프링에서 관리하는 객체를 받아서 사용할 수 있다.
    // 이때 객체는 톰캣에서 생성하는 객체 전부와 Spring.webd에서 제공하는 것들로 구성된다.
    // request, response, session, cookie,... @RequestParam, SessionAttribute
    @GetMapping("/mult.do")
    public ModelAndView mult(
            ModelAndView mv,
            // ModelAndView ; 랜더링할 뷰를 지정하고 거기에 객채를 전달해주는 역할. ModelAndView 객체는 모델 데이터와 뷰 정보를 함께 포함하는 객체.
            HttpServletRequest req,
            HttpServletResponse resp) throws IOException {

        // 원하면 톰캣 코드처럼 쓸 수 있음을 보여주기 위해 작업하는 것
        String xStr = req.getParameter("x");
        String yStr = req.getParameter("y");
        if (xStr != null && yStr != null) {
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            mv.addObject("mult", x * y);
        } else {
            resp.sendError(400);
        }

        mv.setViewName("mult"); // = WEB-INF/views/mult.html
        return mv;
    }
    /*
    ModelAndView 메서드
        setViewName(String viewName): 뷰 이름을 설정합니다.
        getViewName(): 설정된 뷰 이름을 반환합니다.
        addObject(String attributeName, Object attributeValue): 모델에 속성을 추가합니다.
        addObject(Object attributeValue):  모델에 익명 속성을 추가합니다.(주로 클래스를 모델 안에 넣고, 호출하 때는 객체.필드 방식으로 호출)
        getModel(): 모델 데이터를 반환합니다.
        clear(): 모델 데이터를 모두 제거합니다.
    */



    @GetMapping("/minus.do")
    public void minus(@RequestParam(defaultValue = "0") int a,
                      @RequestParam(defaultValue = "0") int b,
                      Model model) {
        // void면 자동으로 주소(minus.do)에서 minus만 빼서 앞에 prefix, 뒤에 suffix(.html)을 붙인다.

        // a,b 변수를 받아올 때 아무 문제 없게 만드는 방법
        // 1) 랩퍼클래스로 만든다.
        // 2) @RequestParam를 사용한다.
        // 3) int를 파싱한다.

        int result = a - b;
        model.addAttribute("result", result); // 뷰에 랜더링할 때 이 객체를 써라
        // Model 객체는 내부적으로 Map<String, Object>와 유사한 구조

        // void면 알아서 메서드 이름으로 뷰 경로를 매핑하고, model는 전달할 객체만 보내는 것.
    }



    @GetMapping("/user.json")
    @ResponseBody // (뷰로 랜더링하지 않고, 문자열 그 자체로 응답하겠다.)
    public String user() throws IOException {
        return "{\"name\":\"Joe\",\"age\":18}";
    }


    @GetMapping("/userMap.json")
    @ResponseBody // Map이나 DTO를 반환하면, 자동으로 json으로
    public Map<String, Object> userMap() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Joe");
        map.put("age", 18);
        map.put("married", false);
        map.put("id", "asdfafd");
        map.put("email", "asdfafd@gmail.com");
        return map;
    }

    @GetMapping("/userDto.json")
    @ResponseBody
    public UserDto userDto() {
        UserDto userDto = new UserDto();
        userDto.setName("Joe");
        userDto.setAge(18);
        userDto.setPw("asdfafd");
        userDto.setAddress("신촌 어딘가");
        String dateStr = "1934-02-02";
        LocalDate bdate = LocalDate.parse(dateStr);
        userDto.setBirthday(bdate);
        return userDto;
    }
    // Jackson은 Java 개발에서 널리 사용되는 JSON 처리 라이브러리입니다.
    // Map 또는 Dto가 Json으로 출력(바인딩)하는 라이브러리가 jackson
    // 이 라이브러리는 JSON 데이터를 Java 객체로 변환하거나, Java 객체를 JSON 데이터로 변환하는 데 사용




    @PostMapping("/signup.do")
    public String signup(
            @ModelAttribute UserDto userDto) { // @ModelAttribute을 써도 되고 안써도 됨

        // html에서 input에 name만 dto 필드와 맞춰주면, 알아서 set~~메서드로 dto 객체의 필드값을 설정해줌
        // @ModelAttribute; 요청 파라미터를 바탕으로 모델 객체를 바인딩하고, 이를 컨트롤러 메서드의 매개변수로 사용
        // @RequestBody는 요청의 본문(body)을 읽어와서 객체로 변환합니다. 주로 JSON 데이터를 처리하는 데 사용
        // @RequestParam는 Map을 똑같이 맞춰서 넣어줌
        // (요청 파라미터를 메서드 매개변수에 바인딩할 때 사용됩니다. 예를 들어, URL 쿼리 파라미터를 메서드 파라미터로 받을 수 있습니다.)

        System.out.println(userDto);
        // action 페이지; 어떤 처리만 하고 뷰를 렌더링하지 않는 페이지
        // 주로 action 페이지는 처리만하고 리디렉트한다.

        return "redirect:/";  // == resp.sendRedirect("/")
        // redirect: 접두사를 사용하면 브라우저가 서버로부터 리다이렉트 응답을 받아 해당 URL로 이동합니다.
        // 이는 클라이언트 측에서 새로운 요청을 생성하는 방식입니다.
    }


}
