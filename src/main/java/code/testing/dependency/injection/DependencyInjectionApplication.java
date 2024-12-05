package code.testing.dependency.injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);

        // if the error shows up, it means NullPointerException caught successfully
        EmailService emailService = new EmailService();
        emailService.process("test@baeldung.com");
    }
}
