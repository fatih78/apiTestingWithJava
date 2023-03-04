package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RestTemplateTests {
    public final String BASIC_URL = "http://localhost:8000";

    @LocalServerPort
    public int port = 8000;

    @Autowired
    public TestRestTemplate restTemplate;
    public HttpHeaders headers = new HttpHeaders();

    @Test
    //        restTemplate
    public void endPointShouldContainRaki() throws Exception {
        assertThat(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/drinks",
                                String.class))
                .contains("Raki");
    }

    @Test
    //        restTemplate
    public void endPointShouldContainAlcoholic() throws Exception {
        assertThat(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/drinks",
                                String.class))
                .contains("alcoholic");
    }

    @Test
    //        restTemplate
    public void endPointShouldContainNonAlcoholic() throws Exception {
        assertThat(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/drinks",
                                String.class))
                .contains("non-alcoholic");
    }

    @Test
    //        restTemplate
    public void endPointShouldContainCola() throws Exception {
        assertThat(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/drinks",
                                String.class))
                .contains("Cola");
    }

    @Test
    //        restTemplate
    public void endPointShouldContainGazoz() throws Exception {
        assertThat(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/drinks",
                                String.class))
                .contains("Gazoz");
    }

    @Test
    //        restTemplate
    public void endPointAddNewProduct() {

        String requestJson = "{\n" + "  \"name\": \"test5\",\n" + "  \"sort\": \"alcoholic\",\n" + "  \"abv\": 0,\n" + "  \"email\" : \"test@gmail.com\",\n" + "  \"id\": 7,\n" + "  \"country\": \"NL\"\n" + "}";
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks", HttpMethod.POST, entity, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
        System.out.println(result);

    }

    @Test
    //        restTemplate
    public void endPointDeleteProduct() {

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks/4", HttpMethod.DELETE, entity, String.class);

        Assertions.assertEquals(204, result.getStatusCodeValue());
        System.out.println(result);

    }

    @Test
    //        restTemplate
    public void endPointAddProduct() throws JSONException {
        // create request body
        JSONObject request = new JSONObject();
        request.put("name", "test6");
        request.put("sort", "alcoholic");
        request.put("email", "test@gmail.com");
        request.put("country", "NL");
        request.put("id", "4");
        request.put("abv", "0");

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(request.toString(),headers);
        ResponseEntity<String> result = restTemplate
                .exchange(BASIC_URL + "/drinks", HttpMethod.POST, entity, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
        System.out.println(result);

    }

}
