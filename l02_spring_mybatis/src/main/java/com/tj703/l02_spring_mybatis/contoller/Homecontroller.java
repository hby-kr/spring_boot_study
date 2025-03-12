package com.tj703.l02_spring_mybatis.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Homecontroller {

    // 방법1
    @Autowired // 스프링 컨테이너에 있는 객체를 요구할 때 사용 (컨테이너에서 관리되고 있을 때만 객체를 주입)
    // @Autowired는 컴포넌트(component) 하위에서 주로 사용된다
    // @Service, @Repository, @Controller는 모두 Component의 확장 버전.
    private DataSource dataSource;
    // DataSource는 스프링 프레임워크에서 주로 사용되며, 데이터베이스 연결 풀을 관리하는 객체로, DB연결을 생성, 유지, 해제하는 데 필요한 설정을 제공
    // 타입을 DataSource보다 좀더 부모 클래스를 썼을 때, 주입할 객체를 잘못 줄 수 있는 가능성이 있으니 주의

    @GetMapping("/")
    public String home(Model model) throws Exception {

        // 톰캣 방식을 다시 해보는 것.
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from departments where dept_no = 'd001'");
        Map<String, String> map = new HashMap();
        if (rs.next()) {
            map.put("dept_no", rs.getString("dept_no"));
            map.put("dept_name", rs.getString("dept_name"));
        }
        System.out.println(map);


        model.addAttribute("dept", map); // Map<String, Object>

        return "index";
    }


}
