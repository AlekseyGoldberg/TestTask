package com.example.test.handler;

import com.example.test.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static final String OK="ok";
    public static final String FILE_EXIST="this file exist";
    public static final String INTERNAL_SERVICE_ERROR="internal service error";

    public static ResponseEntity<ResponseDto> createResponse(String message, HttpStatus status) {
        ResponseDto dto = new ResponseDto(message);
        return new ResponseEntity<>(dto, status);
    }
}
