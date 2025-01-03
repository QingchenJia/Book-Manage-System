package BookManageSystem;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("BookManageSystem.mapper")
@Slf4j
public class BookManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManageSystemApplication.class, args);
        log.info("""
                
                ----------------------------------------------------------
                \tWeb-Url:\thttps://127.0.0.1:9090/index.html
                ----------------------------------------------------------""");
    }

}
