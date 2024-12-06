package code.testing.dependency.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor // good practice for catching NullPointerException
public class EmailService {

//     private final EmailValidator emailValidator; // good practice for catching NullPointerException
    @Autowired
    private EmailValidator emailValidator; // bad practice for catching NullPointerException

    public void process(String email) {
        if(!emailValidator.isValid(email)){
            throw new IllegalArgumentException("INVALID_EMAIL");
        }
    }
}