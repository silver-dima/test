package com.mabaya.test.web.rest;

import com.mabaya.test.exception.NotFoundException;
import com.mabaya.test.exception.TestGeneralException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({TestGeneralException.class})
    protected ResponseEntity handleMabayaGeneral(TestGeneralException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<?> handleNotFound(NotFoundException e) {
        log.error("Not found exception", e);
        return ResponseEntity.notFound().build();
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Http message not readable", ex);
        return new ResponseEntity<Object>("{\"error\": \"" + ex.getCause().getMessage() + "\"}", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<?> ErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("Handle exception", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<?> handleThrowable(Throwable throwable, HttpServletRequest httpRequest) {
        log.error("Handle throwable", throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
