package jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDatasource(){
        System.out.println("配置德鲁伊数据源");
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean statViewServlet(){
        System.out.println("配置Bean");
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        后台的账号密码
        HashMap<String,String> initParameters=new HashMap<>();
//        添加配置
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","admin");
        initParameters.put("allow","");
        bean.setInitParameters(initParameters);
        System.out.println("配置Bean2");
        return  bean;

    }
}
