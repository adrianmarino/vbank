package com.nonosoft.vbank.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;import java.util.List;

public class ResponseUtils {

    public static <ENTITY> ResponseEntity<List<ENTITY>> toPageResponse(Page<ENTITY> page) {
        List<ENTITY> result = page.getContent();
        return new ResponseEntity<>(result, result.isEmpty() ? NOT_FOUND : OK);
    }

    private ResponseUtils() { }
}
