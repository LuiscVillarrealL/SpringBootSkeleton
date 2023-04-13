package com.lcvl.springskel.services.impl;

import com.lcvl.springskel.model.Example;
import com.lcvl.springskel.repository.ExampleRepo;
import com.lcvl.springskel.response.error.exceptions.ActionErrorException;
import com.lcvl.springskel.response.error.exceptions.ExampleNotFoundException;
import com.lcvl.springskel.response.error.exceptions.NoDataFoundException;
import com.lcvl.springskel.services.ExampleService;

import java.util.Collection;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class ExampleServiceImpl.
 */
@Service
@Transactional
@Slf4j
public class ExampleServiceImpl implements ExampleService {

  // private static final Logger log = LoggerFactory.getLogger(ExampleService.class);
  private ExampleRepo exampleRepo;

  @Autowired
  public ExampleServiceImpl(ExampleRepo exampleRepo) {
    this.exampleRepo = exampleRepo;
  }

  @Override
  public void save(Example example) {

    log.info("Saving example:" + example.getUserName());
    exampleRepo.save(example);

  }

  @Override
  public Collection<Example> list() {
    log.info("Fetching examples");

    Collection<Example> examples = exampleRepo.findAll().stream().toList();

    if (examples.isEmpty()) {
      throw new NoDataFoundException();
    }

    return examples;
  }

  @Override
  public Example get(Long id) {
    log.info("Searching examples:" + id);

    Example example = exampleRepo.getReferenceById(id);

    if (ObjectUtils.isEmpty(example)) {
      throw new ExampleNotFoundException("Example " + id + "not found");
    }

    return example;

  }

  @Override
  public void delete(Long id) {

    log.info("deleting example: " + id);

    try {
      
      exampleRepo.deleteById(id);
      
    } catch (InvalidDataAccessApiUsageException e) {

      throw new ActionErrorException("Error deleting");
    }

  }

  @Override
  public Example findByUsername(String username) {

    log.info("Searching by username = " + username);

    Example example = exampleRepo.findByUserName(username);

    if (ObjectUtils.isEmpty(example)) {
      throw new ExampleNotFoundException("Example " + username + "not found");
    }

    return example;

  }

}
