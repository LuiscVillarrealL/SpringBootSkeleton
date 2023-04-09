package com.lcvl.springskel.services.impl;

import com.lcvl.springskel.dao.ExampleDao;
import com.lcvl.springskel.model.Example;
import com.lcvl.springskel.services.ExampleService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
  private ExampleDao exampleDao;

  @Autowired
  public ExampleServiceImpl(ExampleDao exampleDao) {
    this.exampleDao = exampleDao;
  }

  @Override
  public void save(Example example) {

    log.info("Saving example:" + example.getUserName());
    exampleDao.save(example);

  }

  @Override
  public Collection<Example> list() {
    log.info("Fetching examples");

    return exampleDao.findAll().stream().toList();
  }

  @Override
  public Example get(int id) {
    log.info("Searching examples:" + id);
    return exampleDao.findById(id);
  }

  @Override
  public void delete(int id) {

    log.info("deleting example: " + id);
    exampleDao.deleteById(id);
  }

  @Override
  public Example getByUsername(String username) {

    log.info("Searching by username = " + username);

    return exampleDao.findByUsername(username);

  }

}
