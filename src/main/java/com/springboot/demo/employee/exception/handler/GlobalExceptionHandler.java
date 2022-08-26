package com.springboot.demo.employee.exception.handler;

import com.springboot.demo.employee.v1.response.ErrorResponse;
import com.springboot.demo.employee.exception.EmployeeNotFoundException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(
                httpStatus.value(), "Resource Not Found Exception", exception.getMessage());
        return this.build(response, httpStatus);
    }

    @Override
    public ResponseEntity<Object> handleBindException(org.springframework.validation.BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Bind Exception", "Address already in use.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Conversion Not Supported Exception", "Unable to perform type conversion of field value(s).");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Http Media Type Not Acceptable Exception", "Invalid Accept header.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Http Media Type Not Supported Exception", "Invalid Content-Type header.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Http Message Not Readable Exception", "Invalid field(s) in JSON request.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Http Message Not Writable Exception", "Invalid field(s) in JSON response payload.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Http Request Method Not Supported Exception", "Invalid HTTP request method type.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Method Argument Not Valid Exception", "Invalid argument(s) in HTTP request uri.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Missing Servlet Request Parameter Exception", "Missing argument(s) in HTTP request uri.");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Type Mismatch Exception", "Invalid type of field value(s).");
        return this.build(response, status);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                status.value(), "Unknown Exception", "Unable to provide resolution to this error.");
        return this.build(response, status);
    }

    private ResponseEntity<Object> build(ErrorResponse response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
