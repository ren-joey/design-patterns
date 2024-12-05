package code.testing.dependency.injection;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
    public boolean isValid(String email) {
        return email.contains("@");
    }
}
