package jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/adduser")
    public String userInsert(){
        System.out.println("------------------------------------------------------------------------------->");
        String sql="insert into userList (user,password) values ('xiaoming','123456')";
        jdbcTemplate.update(sql);
        return "addOK";
    }

    @GetMapping("/updateuser/{id}")
    public String userUpdate(@PathVariable("id") int id){
        System.out.println("-------------------------------------------------------------------->");
        String sql="update userList set user=?,password=? where password="+id;
        Object[] objects=new Object[2];
        objects[0]="AAAA";
        objects[1]="123456";
        jdbcTemplate.update(sql,objects);
        return "updateOk";
    }

    @GetMapping("/deleteuser/{id}")
    public String userDelete(@PathVariable("id") String id){
        String sql="delete from userlist where user=?";
        jdbcTemplate.update(sql,id);
        return "deleteOK";
    }
}
