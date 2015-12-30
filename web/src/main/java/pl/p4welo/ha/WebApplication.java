package pl.p4welo.ha;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.p4welo.ha.service.UserService;

import javax.annotation.Resource;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    @Resource
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (userService.isEmpty()) {
            userService.createDefaultUser();
        }
    }
}
