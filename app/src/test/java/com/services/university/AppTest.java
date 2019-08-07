package com.services.university;

import com.services.university.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

    @LocalServerPort
    int port;

    private String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setup() {
        url = "http://localhost:" + port + "/universities";
    }

    @Test
    public void getTest() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url, String.class);
        Util.assertOk(responseEntity.getStatusCode());

    }

    @Test
    public void postTest() {
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, Util.getUniversity(), String.class);
        Util.assertCreated(responseEntity.getStatusCode());
    }
}