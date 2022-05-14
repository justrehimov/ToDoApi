package com.nsp.todo.controller;

import com.nsp.todo.enums.Status;
import com.nsp.todo.exception.*;
import com.nsp.todo.model.response.Response;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(UserException.class)
    public Response handleUserException(UserException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(LanguageException.class)
    public Response handleLanguageException(LanguageException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(TechnologyException.class)
    public Response handleTechnologyException(TechnologyException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(CountryException.class)
    public Response handleCountryException(CountryException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(CityException.class)
    public Response handleCityException(CityException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(AnswerException.class)
    public Response handleAnswerException(AnswerException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(TaskException.class)
    public Response handleTaskException(TaskException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(TokenException.class)
    public Response handleTokenException(TokenException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(ValidationException.class)
    public Response handleValidationException(ValidationException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(CvException.class)
    public Response handleCvException(CvException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(AddressException.class)
    public Response handleAddressException(AddressException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(NotificationException.class)
    public Response handleNotificationException(NotificationException ex){
        return Response.builder()
                .status(ex.getStatus().name())
                .message(ex.getStatus().getMessage())
                .errors(ex.getErrors())
                .code(ex.getStatus().getCode())
                .build();
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public Response handleSocketTimeoutException(SocketTimeoutException ex){
        return Response.builder()
                .status(Status.EMAIL_SENT_ERROR.name())
                .message(Status.EMAIL_SENT_ERROR.getMessage())
                .errors(new HashSet<>())
                .code(Status.EMAIL_SENT_ERROR.getCode())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(BindingResult ex){
        return Response.builder()
                .status(Status.VALIDATION_ERROR.name())
                .message(Status.VALIDATION_ERROR.getMessage())
                .errors(ex.getFieldErrors().stream().map(e->e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toSet()))
                .code(Status.VALIDATION_ERROR.getCode())
                .build();
    }


}
