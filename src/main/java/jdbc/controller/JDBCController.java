package jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userlist")
    public List<Map<String,Object>> userList(){
        System.out.println("------------------------------------------------------------------------>");

        String sql="select * from userList";
        List<Map<String,Object>> maps=jdbcTemplate.queryForList(sql);

        return maps;
    }
}
