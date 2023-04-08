package com.vynnychuk.humanresorces.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExeption extends BaseExeption {
    public BadRequestExeption(String message) {
        super(message);
    }
}