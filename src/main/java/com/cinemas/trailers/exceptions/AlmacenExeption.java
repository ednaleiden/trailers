package com.cinemas.trailers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlmacenExeption extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public  AlmacenExeption(String message)
    {
        super(message);
    }

    public AlmacenExeption(String message, Throwable excepcion){

        super(message,excepcion);
    }
}
