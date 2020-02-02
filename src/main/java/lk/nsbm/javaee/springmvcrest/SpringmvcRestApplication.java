package lk.nsbm.javaee.springmvcrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringmvcRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcRestApplication.class, args);
    }


}
