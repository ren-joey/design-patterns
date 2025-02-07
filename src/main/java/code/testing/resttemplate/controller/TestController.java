package code.testing.resttemplate.controller;

import code.testing.resttemplate.util.RestSender;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final RestSender restSender;

    @GetMapping("/test/sendRequest")
    public String sendRequest() {
        return restSender.sendRequest("http://localhost:8071/test/receiver", HttpMethod.GET);
    }

    @GetMapping("/test/receiver")
    public String receiver() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Optional<Cookie[]> cookies = Optional.ofNullable(attr.getRequest().getCookies());
        if (cookies.isPresent()) {
            Optional<Cookie> jwtCookie =
                    Stream.of(cookies.get()).filter(cookie -> cookie.getName().equals(RestSender.JWT_NAME)).findFirst();
            if (jwtCookie.isPresent()) {
                return jwtCookie.get().getValue();
            }
        }
        return "";
    }
}
