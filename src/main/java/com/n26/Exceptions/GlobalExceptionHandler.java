package com.n26.Exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public void httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletResponse response) {
        if (ex.getCause() instanceof InvalidFormatException)
            response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        else
            response.setStatus(HttpStatus.BAD_REQUEST.value());

    }
}
