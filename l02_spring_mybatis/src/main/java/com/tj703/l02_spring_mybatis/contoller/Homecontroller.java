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
    @Autowired // 컨테이너에 있는 객체를 요구할 때 사용 (컨테이너에서 관리되고 있을 때만 객체를 주입)
    // @Autowired는 컴포넌트(component) 하위에만 된다(Controller가 component이므로). 즉 컨테이너 안에서 두 객체가 주고받는 것임.
    private DataSource dataSource;
    // 타입을 DataSource보다 좀더 부모 클래스를 썼을 때, 주입할 객체를 잘못 줄 수 있는 가능성이 있음
    // DataSource는 데이터베이스 연결 풀을 관리하는 객체로, 데이터베이스와의 연결을 관리하고 재사용할 수 있게 해줌.
    

    @GetMapping("/")
    public String home(Model model) throws Exception {
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
