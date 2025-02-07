package code.testing.resttemplate.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
public class RestSender {
    private final static int TIMEOUT = 60000;
    public final static String JWT_NAME = "dms-jwt";
    private final static String JWT = "eyJhbGciOiJSUzI1NiIsInppcCI6IkRFRiJ9.eNqqVkqtKFCyMjQ3trAwsTC3NNRRKigtKsgvTlWyUnLzD4p39PFR0lHKTc1NSi3yS8wFCXv5u0bqBbn6KTzZvfv50mkvFyyBq3BMTs4vzSsBKsrKT63UK0rNg0t5pgBFQ13LLZRqAQAAAP__.Vy_nloBgjiixUqU0Rsoh5ZaGGtQ5j6oJTawFW9piObA32Vd9MBk2QUxMhrM2VeNHVjhJVOfSAdEy-hr0qpkhQDoKBg1VQWsu98t_oKns0-dE_LaMRJ6GQRiaWFOHo7M15KjJunZzYNcMy0I_sxAMoBG9JzTNQcXGDtzx_eKhcMGd2RLMGDddSqQR060Fp-GWfDrTPKN_uKor1qB_1UZkJLa-r-EJWBrFXdBaPW34SgsTZz7cnJdU8wkJ96KxszQbzEusmsNM-DTYrEZyveJyutIupdZ3498GoG-dUUDGzbv8_FpnDTrWjki1vY7vm7EGFWbMekiWZohEzTclb547FWeNB_NSHaXMFkCUZ_bMsDDyd0JaQmylFAKR0ObQfe0Zes55iezdkofs_iQoKvs3dZFXn6Ixodw4ypg3NKq5e0XZyYpmZFAcOWpfQw03SFyww8Pb7xvJBZ0rkg9-2UTWnKJyCBpzlV0KoVPKgkBkRhe8Gy1cMRcrsF7XgBRVCBaQOzzjYBj5chnLV53bYYa_DTIxBSRKSci92hZ-uQ88nTykZPAYFgAHuloiYoQe_egVWO1oJQIJBXsLvoVHS6BA2yEfgbJzUU9ZPCoxlVHuICm2i4PGxkGYSdtdEsAmXzyP8rn2HexbDdTazKJ8lX2JVr4ICcWE0J-T6hE3n5l4KkA";
    private final RestTemplate defultRestTemplate;

    public RestSender(RestTemplateBuilder restTemplateBuilder) {
        this.defultRestTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(TIMEOUT)).build();

    }

    public String sendRequest(String url, HttpMethod method) {
        HttpHeaders header = new HttpHeaders();
        header.add("Cookie", JWT_NAME + "=" + JWT);
        HttpEntity<Object> entity = new HttpEntity<>(null, header);
        return defultRestTemplate.exchange(
                url,
                method,
                entity,
                String.class
        ).toString();
    }
}
