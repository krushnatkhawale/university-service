package com.service.university.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Util {


    public static void assertOk(HttpStatus statusCode) {
        assertEquals(HttpStatus.OK, statusCode);
    }

    public static JSONObject getRequestBodyAsJson(ResponseEntity<String> forEntity) {
        try {
            return new JSONObject(forEntity.getBody());
        } catch (Exception e) {
            fail("Error while parsing response to JSON: " + e.getMessage());
        }
        return null;
    }

    public static JSONArray getRequestBodyAsJsonArray(ResponseEntity<String> forEntity) {
        try {
            return new JSONArray(forEntity.getBody());
        } catch (Exception e) {
            fail("Error while parsing response to JSON: " + e.getMessage());
        }
        return null;
    }

    public static University getUniversity() {
        return new University();
    }
}