package com.example.demo;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import utils.RestTemplateController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RestTemplateTests {
    RestTemplateController controller = new RestTemplateController();
    public final String requestJson = "{\n" + "  \"name\": \"test5\",\n" + "  \"sort\": \"alcoholic\",\n" + "  \"abv\": 0,\n" + "  \"email\" : \"test@gmail.com\",\n" + "  \"id\": 7,\n" + "  \"country\": \"NL\"\n" + "}";

    @LocalServerPort
    public int port = 8000;

    @Autowired
    public TestRestTemplate restTemplate;


    @Test
    //        restTemplate
    public void endPointShouldContainRaki() throws Exception {
        assertThat(controller.getEndPoint("Raki"));
    }

    @Test
    //        restTemplate
    public void endPointShouldContainAlcoholic() throws Exception {
        assertThat(controller.getEndPoint("alcoholic"));
    }

    @Test
    //        restTemplate
    public void endPointShouldContainNonAlcoholic() throws Exception {
        assertThat(controller.getEndPoint("non-alcoholic"));
    }

    @Test
    //        restTemplate
    public void endPointShouldContainCola() throws Exception {
        assertThat(controller.getEndPoint("Cola"));
    }

    @Test
    //        restTemplate
    public void endPointShouldContainGazoz() throws Exception {
        assertThat(controller.getEndPoint("Gazoz"));
    }

    @Test
    //        restTemplate
    public void endPointAddNewProduct() throws Exception {
        controller.addNewProduct(requestJson);
        assertThat(controller.getEndPoint("test5"));
        endPointDeleteProduct("7");
    }


    @Test
    //        restTemplate
    public void endPointAddProduct() throws Exception {
        // create request body
        JSONObject requestbody = new JSONObject();
        requestbody.put("name", "test6");
        requestbody.put("sort", "alcoholic");
        requestbody.put("email", "test@gmail.com");
        requestbody.put("country", "NL");
        requestbody.put("id", "4");
        requestbody.put("abv", "0");

        controller.addNewProductJson(requestbody);
        endPointDeleteProduct("4");

    }

    private void endPointDeleteProduct(String n) throws Exception {
        controller.deleteProduct(Integer.parseInt(n));
    }

}
