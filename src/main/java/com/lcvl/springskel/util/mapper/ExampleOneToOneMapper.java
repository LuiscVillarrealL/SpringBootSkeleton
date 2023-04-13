package com.lcvl.springskel.util.mapper;

import com.lcvl.springskel.dto.ExampleOneToOneDto;
import com.lcvl.springskel.model.ExampleOneToOne;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExampleMapper.
 */
@Mapper(componentModel = "spring", uses = {ExampleMapper.class})
public interface ExampleOneToOneMapper {

  @Mapping (target="exampleDto", source="example")
  ExampleOneToOneDto exampleOneToOneModelToDto(ExampleOneToOne exampleOneToOne);

  @Mapping (target="example", source="exampleDto")
  ExampleOneToOne exampleOneToOneDtoToModel(ExampleOneToOneDto exampleOneToOneDto);

}
