package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ZooGlobalExceptionHandler {



    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> HandleZooException(ZooException zooException) {
        ZooErrorResponse errorResponse = new ZooErrorResponse(
                zooException.getHttpStatus().value(),
                zooException.getLocalizedMessage(),
                System.currentTimeMillis());
        log.error("Exception occured= ", zooException);

        return new ResponseEntity<>(errorResponse, zooException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> HandleZooException(Exception zooException) {
        ZooErrorResponse errorResponse = new ZooErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                zooException.getLocalizedMessage(),
                System.currentTimeMillis());
        log.error("Exception occured= ", zooException);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
