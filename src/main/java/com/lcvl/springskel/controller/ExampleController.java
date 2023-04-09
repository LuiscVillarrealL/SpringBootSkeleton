package com.lcvl.springskel.controller;

import com.lcvl.springskel.dto.ExampleDto;
import com.lcvl.springskel.model.Example;
import com.lcvl.springskel.services.ExampleService;
import com.lcvl.springskel.util.mapper.ExampleMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ExampleController.
 */
@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

  /** The example mapper. */
  private ExampleMapper exampleMapper;

  /** The example service. */
  private ExampleService exampleService;

  /**
   * Instantiates a new example controller.
   *
   * @param exampleMapper the example mapper
   * @param exampleService the example service
   */
  @Autowired
  public ExampleController(ExampleMapper exampleMapper, ExampleService exampleService) {
    this.exampleMapper = exampleMapper;
    this.exampleService = exampleService;
  }

  /**
   * Gets the examples.
   *
   * @return the examples
   */
  @GetMapping("/examples")
  public List<ExampleDto> getExamples() {

    List<ExampleDto> exampleDtoList = new ArrayList<>();
    Collection<Example> exampleList = new ArrayList<>();

    exampleList = exampleService.list();
    for (Example example : exampleList) {
      exampleDtoList.add(exampleMapper.exampleModelToDto(example));
    }

    return exampleDtoList;
  }

  /**
   * Gets the hello world.
   *
   * @return the hello world
   */
  @GetMapping("/hello")
  public String getHelloWorld() {

    return "Hello WOrld";
  }

  /**
   * Creates the user.
   *
   * @param example the example
   */
  @PostMapping("/create")
  public void createUser(@RequestBody @Valid ExampleDto example) {

    example.setId(0);

    exampleService.save(exampleMapper.exampleDtoToModel(example));

  }

}
