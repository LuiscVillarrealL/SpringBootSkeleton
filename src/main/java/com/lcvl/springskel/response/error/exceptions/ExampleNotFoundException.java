package com.lcvl.springskel.response.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class UserNotFoundException.
 */
@ResponseStatus(
    value = HttpStatus.NOT_FOUND)

public class ExampleNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 9134428602121979815L;

  /**
   * Instantiates a new user not found exception.
   *
   * @param message the message
   */
  public ExampleNotFoundException(String message) {

    super(message);

  }
}
