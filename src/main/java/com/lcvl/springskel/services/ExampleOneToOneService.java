package com.lcvl.springskel.services;

import java.util.Collection;

import com.lcvl.springskel.model.ExampleOneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExampleOneToOneService.
 */
public interface ExampleOneToOneService {

  /**
   * Save.
   *
   * @param exampleOneToOne the exampleOneToOne
   */
  void save(ExampleOneToOne exampleOneToOne);

  /**
   * List.
   *
   * @return the collection
   */
  Collection<ExampleOneToOne> list();

  /**
   * Gets the.
   *
   * @param id the id
   * @return the exampleOneToOne
   */
  ExampleOneToOne get(Long id);

  /**
   * Delete.
   *
   * @param id the id
   */
  void delete(Long id);
  
  
  /**
   * Delete by exampleOneToOne id.
   *
   * @param id the id
   */
  void deleteByExampleOneToOneId(Long id);


}
