package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RestAssuredTests {
    @LocalServerPort
    public int port = 8000;



    @Test
//    RestAssured
    public void shouldContainABV() {
        given().
                when().
                get("http://localhost:" + port + "/drinks").
                then().
                assertThat().
                statusCode(200);

    }

}
