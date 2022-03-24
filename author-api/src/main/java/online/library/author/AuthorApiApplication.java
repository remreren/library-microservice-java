package online.library.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorApiApplication.class, args);
    }

}
