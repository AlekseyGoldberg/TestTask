package com.example.test.controller;

import com.example.test.dto.RequestDto;
import com.example.test.dto.ResponseDto;
import com.example.test.exception.FileExistException;
import com.example.test.handler.ResponseHandler;
import com.example.test.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class FileController {
    private FileService service;

    @PostMapping("/file")
    public ResponseEntity<ResponseDto> saveFile(@RequestBody RequestDto dto) {
        try {
            service.saveFile(dto);
            return ResponseHandler.createResponse(ResponseHandler.OK, HttpStatus.OK);
        } catch (FileExistException e) {
            log.error(e.getMessage(), e);
            return ResponseHandler.createResponse(ResponseHandler.FILE_EXIST, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseHandler.createResponse(ResponseHandler.INTERNAL_SERVICE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
