package code.testing.dependency.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BeanGather {
    private final EmailServiceMultipleConstructor emailServiceMultipleConstructor;

    @GetMapping("/")
    public Boolean tryMailValidator() {
        return emailServiceMultipleConstructor.process("test@com");
    }
}
