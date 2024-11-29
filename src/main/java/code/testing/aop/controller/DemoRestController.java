package code.testing.aop.controller;

import code.testing.aop.annotation.EnableRestCallLogs;
import code.testing.aop.dto.InputRequestDto;
import code.testing.aop.dto.OutputResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @GetMapping("/testGet/{name}")
    @ResponseStatus(HttpStatus.OK)
    @EnableRestCallLogs
    public OutputResponseDto testGetEndPoint(@PathVariable String name) {

        OutputResponseDto result = new OutputResponseDto();
        result.setResponse_state(HttpStatus.OK);
        Map<String, Object> hm= new HashMap<>();
        hm.put("Id", 1);
        hm.put("Input_Name", String.valueOf(name));
        result.setPayload(hm);
        return result;
    }
    @PostMapping("/testPost")
    @ResponseStatus(HttpStatus.CREATED)
    @EnableRestCallLogs
    public OutputResponseDto testPostEndPoint(@RequestBody InputRequestDto inputRequestInfo) {
        OutputResponseDto result=new OutputResponseDto();
        result.setResponse_state(HttpStatus.CREATED);
        Map<String, Object> hm= new HashMap<>();
        hm.put("Payload", inputRequestInfo);
        result.setPayload(hm);
        return result;
    }
}