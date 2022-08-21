package com.springboot.demo.employee.exception;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

@ControllerAdvice
public class EmployeeExceptionHandler {

    private HttpStatus httpStatus;

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        httpStatus = HttpStatus.NOT_FOUND;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Resource Not Found Exception", exception.getMessage());
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<EmployeeErrorResponse> handleBindException(BindException exception) {
        httpStatus = HttpStatus.BAD_REQUEST;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Bind Exception", "Address already in use.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(ConversionNotSupportedException.class)
    public ResponseEntity<EmployeeErrorResponse> handleConversionNotSupportedException(ConversionNotSupportedException exception) {
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Conversion Not Supported Exception", "Unable to perform type conversion of field value(s).");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<EmployeeErrorResponse> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException exception) {
        httpStatus = HttpStatus.NOT_ACCEPTABLE;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Http Media Type Not Acceptable Exception", "Invalid Accept header.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<EmployeeErrorResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Http Media Type Not Supported Exception", "Invalid Content-Type header.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<EmployeeErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        httpStatus = HttpStatus.BAD_REQUEST;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Http Message Not Readable Exception", "Invalid field(s) in JSON request.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<EmployeeErrorResponse> handleHttpMessageNotWritableException(HttpMessageNotWritableException exception) {
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Http Message Not Writable Exception", "Invalid field(s) in JSON response payload.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<EmployeeErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Http Request Method Not Supported Exception", "Invalid HTTP request method type.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        httpStatus = HttpStatus.BAD_REQUEST;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Method Argument Not Valid Exception", "Invalid argument(s) in HTTP request uri.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<EmployeeErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        httpStatus = HttpStatus.BAD_REQUEST;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Missing Servlet Request Parameter Exception", "Missing argument(s) in HTTP request uri.");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<EmployeeErrorResponse> handleTypeMismatchException(TypeMismatchException exception) {
        httpStatus = HttpStatus.BAD_REQUEST;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Type Mismatch Exception", "Invalid type of field value(s).");
        return this.build(response, httpStatus);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleOtherExceptions(Exception exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                httpStatus.value(), "Unknown Exception", "Unable to provide resolution to this error.");
        return this.build(response, httpStatus);
    }

    private ResponseEntity<EmployeeErrorResponse> build(EmployeeErrorResponse response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
