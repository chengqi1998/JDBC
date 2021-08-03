package jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JdbcApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() throws SQLException {

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(dataSource.getClass());

        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();

        String sql="select * from userList";
        List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql);
        System.out.println(maps);

    }

}
