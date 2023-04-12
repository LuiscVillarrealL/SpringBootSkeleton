package com.lcvl.springskel.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ResponseObj.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObj {

  @Schema(
      name = "httpStatus")
  private HttpStatus status;
  @Schema(
      name = "timestamp")
  private Date timestamp;
  @Schema(
      name = "message")
  private String message;

}
