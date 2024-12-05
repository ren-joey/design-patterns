package code.testing.dependency.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailValidator emailValidator;

    public void process(String email) {
        if(!emailValidator.isValid(email)){
            throw new IllegalArgumentException("INVALID_EMAIL");
        }
    }
}