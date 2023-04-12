package com.lcvl.springskel.response.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class ActionErrorException.
 */
@ResponseStatus(
    value = HttpStatus.CONFLICT)
public class ActionErrorException extends RuntimeException {

  private static final long serialVersionUID = -8814328242555936265L;

  /**
   * Instantiates a new user not found exception.
   *
   * @param message the message
   */
  public ActionErrorException(String message) {

    super(message);

  }
}
