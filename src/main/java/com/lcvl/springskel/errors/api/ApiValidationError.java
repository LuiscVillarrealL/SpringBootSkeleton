package com.lcvl.springskel.errors.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class ApiValidationError.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {
  
  private String object;
  private String field;
  private Object rejectedValue;
  private String message;

  ApiValidationError(String object, String message) {
    this.object = object;
    this.message = message;
  }
}
