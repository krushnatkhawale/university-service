package com.service.university.util;

import com.service.university.model.University;
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

    public static void assertCreated(HttpStatus statusCode) {
        assertEquals(HttpStatus.CREATED, statusCode);
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