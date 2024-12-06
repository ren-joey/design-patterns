package code.testing.dependency.injection;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceMultipleConstructor {
    private EmailValidator emailValidator;

    public EmailServiceMultipleConstructor() {
    }

    @Autowired
    public EmailServiceMultipleConstructor(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    public Boolean process(String email) {
        return emailValidator.isValid(email);
    }
}
