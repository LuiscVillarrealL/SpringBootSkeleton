package com.lcvl.springskel.response.error.exceptions;

import com.lcvl.springskel.response.error.api.ApiError;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class GlobalExceptionHandler.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Handle example not found exception.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(ExampleNotFoundException.class)
  public ResponseEntity<Object> handleExampleNotFoundException(ExampleNotFoundException ex,
      WebRequest request) {

    return new ResponseEntity<>(
        createError(HttpStatus.NOT_FOUND, ex.getMessage(), request, "not found"),
        HttpStatus.NOT_FOUND);
  }

  /**
   * Create error.
   *
   * @param status the status
   * @param ex the ex
   * @param request the request
   * @return the api error
   */
  private ApiError createError(HttpStatus status, String ex, WebRequest request, String message) {

    ApiError error = new ApiError();

    error.setStatus(status);
    error.setTimestamp(new Date());
    error.setDebugMessage(ex);
    error.setMessage(ex);

    return error;
  }

  /**
   * Handle nodata found exception.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(NoDataFoundException.class)
  public ResponseEntity<Object> handleNodataFoundException(NoDataFoundException ex,
      WebRequest request) {

    return new ResponseEntity<>(
        createError(HttpStatus.NOT_FOUND, ex.getMessage(), request, "No data found"),
        HttpStatus.NOT_FOUND);
  }

  /**
   * Handle invalid data access api usage exception.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(InvalidDataAccessApiUsageException.class)
  public ResponseEntity<Object> handleInvalidDataAccessApiUsageException(
      InvalidDataAccessApiUsageException ex, WebRequest request) {

    return new ResponseEntity<>(
        createError(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), request, "Error"),
        HttpStatus.METHOD_NOT_ALLOWED);
  }

  /**
   * Handle method argument not valid.
   *
   * @param ex the ex
   * @param headers the headers
   * @param status the status
   * @param request the request
   * @return the response entity
   */
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(x -> x.getDefaultMessage()).collect(Collectors.toList());

    ApiError error = createError(HttpStatus.BAD_REQUEST, ex.getMessage(), request, "Error");

    error.setSubErrors(errors);

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}