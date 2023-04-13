package com.lcvl.springskel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new example dto.
 */
@Data
public class ExampleOneToOneDto {

  /** The id. */
  @Schema(name = "id")
  private long id;

  /** The name. */
  @Schema(name = "name")
  private String name;

  @Schema(name = "example")
  private ExampleDto exampleDto;


}
