package com.lcvl.springskel.controller;

import com.lcvl.springskel.dto.ExampleOneToOneDto;
import com.lcvl.springskel.model.Example;
import com.lcvl.springskel.model.ExampleOneToOne;
import com.lcvl.springskel.response.ResponseHandler;
import com.lcvl.springskel.response.ResponseObj;
import com.lcvl.springskel.services.ExampleOneToOneService;
import com.lcvl.springskel.services.ExampleService;
import com.lcvl.springskel.util.mapper.ExampleOneToOneMapper;

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

@RestController
@RequestMapping("/api")

@RequiredArgsConstructor
public class ExampleOneToOneController {

  private ExampleOneToOneMapper exampleOneToOneMapper;
  private ExampleOneToOneService exampleOneToOneService;
  private ExampleService exampleService;

  @Autowired
  public ExampleOneToOneController(ExampleOneToOneMapper exampleOneToOneMapper,
      ExampleOneToOneService exampleOneToOneService, ExampleService exampleService) {
    this.exampleOneToOneMapper = exampleOneToOneMapper;
    this.exampleOneToOneService = exampleOneToOneService;
    this.exampleService = exampleService;
  }

  @GetMapping("/onetoone")
  public ResponseEntity<Object> getOneToOne() {

    List<ExampleOneToOneDto> exampleOneToOneDtoList = new ArrayList<>();
    Collection<ExampleOneToOne> exampleOneToOneList = new ArrayList<>();

    exampleOneToOneList = exampleOneToOneService.list();
    for (ExampleOneToOne exampleOneToOne : exampleOneToOneList) {
      exampleOneToOneDtoList.add(exampleOneToOneMapper.exampleOneToOneModelToDto(exampleOneToOne));
    }

    return ResponseHandler.generateResponse(
        new ResponseObj(HttpStatus.OK, new Date(), "Examples: "), exampleOneToOneDtoList);
  }

  /**
   * Creates the example one to one.
   *
   * @param exampleId the example id
   * @param onetotone the onetotone
   * @return the response entity
   */
  @PostMapping("/example/{exampleId}/onetoone")
  public ResponseEntity<Object> createExampleOneToOne(@PathVariable(
      value = "exampleId") Long exampleId, @RequestBody @Valid ExampleOneToOneDto onetotone) {

    Example example = exampleService.get(exampleId);

    onetotone.setId(0);

    ExampleOneToOne exampleOneToOne = exampleOneToOneMapper.exampleOneToOneDtoToModel(onetotone);
    
    exampleOneToOne.setExample(example);

    exampleOneToOneService.save(exampleOneToOne);

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "onetoone created"), "");

  }

  @GetMapping("/onetoone/{id}")
  public ResponseEntity<Object> findOneToOne(@PathVariable long id) {

    return ResponseHandler.generateResponse(
        new ResponseObj(HttpStatus.OK, new Date(), "User found"),
        exampleOneToOneMapper.exampleOneToOneModelToDto(exampleOneToOneService.get(id)));

  }

  @PostMapping("/onetoone/delete/{id}")
  public ResponseEntity<Object> deleteOneTOone(@PathVariable long id) {

    exampleOneToOneService.delete(id);

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "User deleted"), "");
  }

  @PostMapping("/onetoone/update/")
  public ResponseEntity<Object> updateOneToOne(@RequestBody @Valid ExampleOneToOneDto onetotone) {

    exampleOneToOneService.save(exampleOneToOneMapper.exampleOneToOneDtoToModel(onetotone));

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "OnetoONe updated"), "");

  }

  @GetMapping("/onetoone/deletebyexample/{example}")
  public ResponseEntity<Object> deleteByExampleId(@PathVariable Long id) {

    exampleOneToOneService.deleteByExampleOneToOneId(id);

    return ResponseHandler
        .generateResponse(new ResponseObj(HttpStatus.OK, new Date(), "User deleted"), "");

  }

}
