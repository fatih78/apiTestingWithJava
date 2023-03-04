package utils;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RestTemplateController {

    protected final String BASIC_URL = "http://localhost:8000";

    @LocalServerPort
    protected int port = 8000;

    @Autowired
    protected TestRestTemplate restTemplate = new TestRestTemplate();
    protected HttpHeaders headers = new HttpHeaders();


    public boolean getEndPoint(String drink) throws Exception {
        headers.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate
                .getForObject(BASIC_URL + "/drinks",
                        String.class).contains(drink);
        return true;
    }

    public String addNewProduct(String requestbody) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(requestbody, headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.CREATED);

        return String.valueOf(result);
    }

    public String deleteProduct(int number) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks/" + number, HttpMethod.DELETE, entity, String.class);
        Assertions.assertEquals(204, result.getStatusCodeValue(), String.valueOf(HttpStatus.OK));

        return String.valueOf(result);
    }


    public String addNewProductJson (JSONObject requestbody) {
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestbody.toString(),headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks", HttpMethod.POST, entity, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
        System.out.println(result);

        return String.valueOf(result);
    }

    public void addNewProductJson(org.json.JSONObject requestbody) {
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestbody.toString(),headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks", HttpMethod.POST, entity, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
        System.out.println(result);
    }
}
