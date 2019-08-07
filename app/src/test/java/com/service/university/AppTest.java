package com.service.university;

import com.service.university.model.University;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.service.university.model.Util.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

    @LocalServerPort
    int port;

    RestTemplate restTemplate = new RestTemplate();
    private String url;

    @Before
    public void setup() {
        url = "http://localhost:" + port + "/universities";
    }

    @Test
    public void getTest() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertOk(responseEntity.getStatusCode());

        JSONArray response = getRequestBodyAsJsonArray(responseEntity);
    }

    @Test
    public void postTest() {
        ResponseEntity<String> forEntity = restTemplate.exchange(url, POST, httpEntityWithOneRecord(), String.class);
        assertEquals(HttpStatus.OK, forEntity.getStatusCode());
    }

    private HttpEntity<University> httpEntityWithOneRecord() {
        return new HttpEntity<>(getUniversity());
    }
}