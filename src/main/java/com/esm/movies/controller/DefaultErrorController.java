package com.esm.movies.controller;

import com.esm.movies.dto.error.ErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Obi on 9/2/2021.
 */
@RestController
public class DefaultErrorController implements ErrorController {

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity error(HttpServletRequest request) {

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        System.out.println("The response code is " + statusCode);
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        String errorMessage = exception == null ? "N/A" : exception.getMessage();
        errorMessage = errorMessage.contains(":") ? errorMessage.substring(errorMessage.indexOf(":")) : errorMessage;

        HttpStatus responseCode;

        ErrorResponse response = new ErrorResponse();
        response.setMessage(errorMessage.trim());
        response.setStatus(statusCode);

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
