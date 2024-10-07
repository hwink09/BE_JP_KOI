package com.example.Koi_Order_System.model.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus
public class KoiApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public KoiApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public KoiApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
