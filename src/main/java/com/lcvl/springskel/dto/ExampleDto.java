package com.lcvl.springskel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new example dto.
 */
@Data
public class ExampleDto {

  /** The id. */
  @Schema(name = "id")
  private int id;

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
