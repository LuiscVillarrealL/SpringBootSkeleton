package com.lcvl.springskel.services;

import java.util.Collection;

import com.lcvl.springskel.model.Example;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExampleService.
 */
public interface ExampleService {

  /**
   * Save.
   *
   * @param example the example
   */
  void save(Example example);

  /**
   * List.
   *
   * @return the collection
   */
  Collection<Example> list();

  /**
   * Gets the.
   *
   * @param id the id
   * @return the example
   */
  Example get(Long id);

  /**
   * Delete.
   *
   * @param id the id
   */
  void delete(Long id);

  /**
   * Finds the by username.
   *
   * @param username the username
   * @return the by username
   */
  Example findByUsername(String username);


}
