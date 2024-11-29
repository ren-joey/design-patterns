package code.testing.aop.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class OutputResponseDto implements Serializable {

    private HttpStatus response_state;
    private Object payload;

    @Override
    public String toString() {
        return "OutputResponseInfo [response_state=" + response_state + ", payload=" + payload + "]";
    }

    public HttpStatus getResponse_state() {
        return response_state;
    }

    public void setResponse_state(HttpStatus response_state) {
        this.response_state = response_state;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}