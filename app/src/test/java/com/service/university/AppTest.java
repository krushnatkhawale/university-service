package com.service.university;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.service.university.model.Util.assertOk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate testRestTemplate;
    private String url;

    @Before
    public void setup() {
        url = "http://localhost:" + port + "/universities";
    }

    @Test
    public void getTest() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url, String.class);
        assertOk(responseEntity.getStatusCode());

        JSONObject response = getRequestBodyAsJson(responseEntity);
    }

    private JSONObject getRequestBodyAsJson(ResponseEntity<String> forEntity) {
        try {
            return new JSONObject(forEntity.getBody());
        } catch (Exception e) {
            fail("Error while parsing repsonse to JSON: " + e.getMessage());
        }
        return null;
    }

    @Test
    public void postTest() {
        ResponseEntity<String> forEntity = testRestTemplate.postForEntity(url, null, String.class);
        assertEquals(HttpStatus.OK, forEntity.getStatusCode());
    }
}