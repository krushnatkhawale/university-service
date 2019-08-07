package com.service.university.model;

import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

public class Util {


    public static void assertOk(HttpStatus statusCode) {
        assertEquals(HttpStatus.OK, statusCode);
    }
}
