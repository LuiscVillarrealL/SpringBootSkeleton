package com.lcvl.springskel.response.error.exceptions;

/**
 * The Class NoDataFoundException.
 */
public class NoDataFoundException extends RuntimeException {

  private static final long serialVersionUID = -1306349951550798810L;

  /**
   * Instantiates a new no data found exception.
   */
  public NoDataFoundException() {

    super("No data found");
  }
}