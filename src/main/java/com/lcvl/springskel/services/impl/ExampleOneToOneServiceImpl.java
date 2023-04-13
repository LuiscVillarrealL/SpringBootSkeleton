package com.lcvl.springskel.services.impl;

import com.lcvl.springskel.model.ExampleOneToOne;
import com.lcvl.springskel.repository.ExampleOneToOneRepo;
import com.lcvl.springskel.response.error.exceptions.ActionErrorException;
import com.lcvl.springskel.response.error.exceptions.ExampleNotFoundException;
import com.lcvl.springskel.response.error.exceptions.NoDataFoundException;
import com.lcvl.springskel.services.ExampleOneToOneService;

import java.util.Collection;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ExampleOneToOneServiceImpl.
 */
@Service
@Transactional
@Slf4j
public class ExampleOneToOneServiceImpl implements ExampleOneToOneService {

  /** The example one to one repo. */
  // private static final Logger log = LoggerFactory.getLogger(ExampleOneToOneService.class);
  private ExampleOneToOneRepo exampleOneToOneRepo;

  /**
   * Instantiates a new example one to one service impl.
   *
   * @param exampleOneToOneRepo the example one to one repo
   */
  @Autowired
  public ExampleOneToOneServiceImpl(ExampleOneToOneRepo exampleOneToOneRepo) {
    this.exampleOneToOneRepo = exampleOneToOneRepo;
  }

  /**
   * Save.
   *
   * @param exampleOneToOne the example one to one
   */
  @Override
  public void save(ExampleOneToOne exampleOneToOne) {

    log.info("Saving example:" + exampleOneToOne.getName());
    exampleOneToOneRepo.save(exampleOneToOne);

  }

  /**
   * List.
   *
   * @return the collection
   */
  @Override
  public Collection<ExampleOneToOne> list() {
    log.info("Fetching examples");

    Collection<ExampleOneToOne> examples = exampleOneToOneRepo.findAll().stream().toList();

    if (examples.isEmpty()) {
      throw new NoDataFoundException();
    }

    return examples;
  }

  /**
   * Gets the.
   *
   * @param id the id
   * @return the example one to one
   */
  @Override
  public ExampleOneToOne get(Long id) {
    log.info("Searching examples:" + id);

    ExampleOneToOne example = exampleOneToOneRepo.getReferenceById(id);

    if (ObjectUtils.isEmpty(example)) {
      throw new ExampleNotFoundException("ExampleOneToOne " + id + "not found");
    }

    return example;

  }

  /**
   * Delete.
   *
   * @param id the id
   */
  @Override
  public void delete(Long id) {

    log.info("deleting example: " + id);

    try {
      
      exampleOneToOneRepo.deleteById(id);
      
    } catch (InvalidDataAccessApiUsageException e) {

      throw new ActionErrorException("Error deleting");
    }

  }

  /**
   * Delete by example one to one id.
   *
   * @param id the id
   */
  @Override
  public void deleteByExampleOneToOneId(Long id) {

    log.info("deleting example: " + id);

    try {
      
      exampleOneToOneRepo.deleteByExampleId(id);
      
    } catch (InvalidDataAccessApiUsageException e) {

      throw new ActionErrorException("Error deleting");
    }

    
  }


}
