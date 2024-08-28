package com.cinemas.trailers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;

@ResponseStatus(code =HttpStatus.NOT_FOUND)
public class FileNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;
public  FileNotFoundException(String message)
{
    super(message);
}

public FileNotFoundException(String message, Throwable excepcion){

    super(message,excepcion);
}

}
