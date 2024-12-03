package code.testing.streaming.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class StreamController {

    @GetMapping("/stream")
    public StreamingResponseBody stream(HttpServletRequest request) {
        String times = Optional.ofNullable(request.getParameter("times"))
                        .filter(s -> !s.isEmpty())
                        .orElse("1");
        int intTimes = Integer.parseInt(times);

        return outputStream -> {
            try {
                for (int i = 0; i < intTimes; i++) {
                    outputStream.write((i + " - ").getBytes());
                    outputStream.flush();

                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        };
    }
}
