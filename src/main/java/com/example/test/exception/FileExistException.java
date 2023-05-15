package com.example.test.exception;

public class FileExistException extends RuntimeException{
    public FileExistException(String message) {
        super(message);
    }
}
