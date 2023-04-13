package com.lcvl.springskel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new example 2 dto.
 */
@Data
public class Example2Dto {

  /** The id. */
  @Schema(name = "id")
  private long id;

  /** The user name. */
  @Schema(name = "userName")
  private String userName;

  /** The first name. */
  @Schema(name = "firstName")
  private String firstName;

  /** The number. */
  @Schema(name = "number")
  private int number;

}
