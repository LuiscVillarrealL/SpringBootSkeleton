package com.lcvl.springskel.response.error.api;

import com.lcvl.springskel.response.ResponseObj;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * The Class ApiError.
 */
@Data
public class ApiError extends ResponseObj {

  @Schema(
      name = "debugMessage")
  private String debugMessage;
  @Schema(
      name = "subErrors")
  private List<String> subErrors;

}
