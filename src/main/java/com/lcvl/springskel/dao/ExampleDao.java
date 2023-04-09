package com.lcvl.springskel.dao;

import java.util.List;

import com.lcvl.springskel.model.Example;

/**
 * The Interface ExampleDAO.
 */
public interface ExampleDao {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Example> findAll();

  /**
   * Find by id.
   *
   * @param id the id
   * @return the example
   */
  Example findById(int id);

  /**
   * Save.
   *
   * @param user the user
   */
  void save(Example user);

  /**
   * Delete by id.
   *
   * @param id the id
   */
  void deleteById(int id);

  /**
   * Find by username.
   *
   * @param username the username
   * @return the example
   */
  Example findByUsername(String username);

}
