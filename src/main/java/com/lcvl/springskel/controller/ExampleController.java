package com.lcvl.springskel.controller;

import com.lcvl.springskel.dto.ExampleDto;
import com.lcvl.springskel.model.Example;
import com.lcvl.springskel.response.ResponseHandler;
import com.lcvl.springskel.response.ResponseObj;
import com.lcvl.springskel.services.ExampleService;
import com.lcvl.springskel.util.mapper.ExampleMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ExampleController.
 */
@RestController
@RequestMapping("/api")
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
  public ResponseEntity<Object> getExamples() {

    List<ExampleDto> exampleDtoList = new ArrayList<>();
    Collection<Example> exampleList = new ArrayList<>();

    exampleList = exampleService.list();
    for (Example example : exampleList) {
      exampleDtoList.add(exampleMapper.exampleModelToDto(example));
    }

    // return ResponseHandler.generateResponse("Examples: ", HttpStatus.OK, exampleDtoList);
    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "Examples: "), exampleDtoList);
  }

  /**
   * Gets the hello world.
   *
   * @return the hello world
   */
  @GetMapping("/hello")
  public ResponseEntity<Object> getHelloWorld() {

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "Hello WOrld"), "Hello WOrld");
  }

  /**
   * Creates the user.
   *
   * @param example the example
   * @return the response entity
   */
  @PostMapping("/create")
  public ResponseEntity<Object> createExample(@RequestBody @Valid ExampleDto example) {

    example.setId(0);

    exampleService.save(exampleMapper.exampleDtoToModel(example));

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "User created"), "");

  }

  /**
   * Find example.
   *
   * @param id the id
   * @return the response entity
   */
  @GetMapping("/example/{id}")
  public ResponseEntity<Object> findExample(@PathVariable long id) {

    return ResponseHandler.generateResponse(
        new ResponseObj(HttpStatus.OK, new Date(), "User found"),
        exampleMapper.exampleModelToDto(exampleService.get(id)));

  }

  /**
   * Update user.
   *
   * @param id the id
   * @return the response entity
   */
  @PostMapping("/delete/{id}")
  public ResponseEntity<Object> updateUser(@PathVariable long id) {

    exampleService.delete(id);

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "User deleted"), "");
  }

  /**
   * Update example.
   *
   * @param example the example
   * @return the response entity
   */
  @PostMapping("/update")
  public ResponseEntity<Object> updateExample(@RequestBody @Valid ExampleDto example) {

    exampleService.save(exampleMapper.exampleDtoToModel(example));

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "User updated"), "");

  }

  /**
   * Find example by username.
   *
   * @param username the username
   * @return the response entity
   */
  @GetMapping("/user/{username}")
  public ResponseEntity<Object> findExampleByUsername(@PathVariable String username) {

    return ResponseHandler.generateResponse(
        new ResponseObj(HttpStatus.OK, new Date(), "User found"),
        exampleMapper.exampleModelToDto(exampleService.findByUsername(username)));

  }

}
