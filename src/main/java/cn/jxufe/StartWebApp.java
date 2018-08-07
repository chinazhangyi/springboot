package cn.jxufe;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Zhang on 2018/8/2.
 */
@SpringBootApplication
@MapperScan("cn.jxufe.dao")
public class StartWebApp {
    public static void main(String[] args) {
        System.out.println("服务器启动");
      SpringApplication.run(StartWebApp.class);
    }
}
