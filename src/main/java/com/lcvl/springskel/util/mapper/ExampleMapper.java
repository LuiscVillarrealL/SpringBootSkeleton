package com.lcvl.springskel.util.mapper;

import org.mapstruct.Mapper;

import com.lcvl.springskel.dto.ExampleDto;
import com.lcvl.springskel.model.Example;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExampleMapper.
 */
@Mapper(componentModel = "spring")
public interface ExampleMapper {

  /**
   * Example model to dto.
   *
   * @param example the example
   * @return the example DTO
   */
  ExampleDto exampleModelToDto(Example example);

  /**
   * Example dto to model.
   *
   * @param exampleDto the example dto
   * @return the example
   */
  Example exampleDtoToModel(ExampleDto exampleDto);

}
