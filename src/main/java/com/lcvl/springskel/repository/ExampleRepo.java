package com.lcvl.springskel.repository;

import com.lcvl.springskel.model.Example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface ExampleRepo.
 */
@Repository
public interface ExampleRepo extends JpaRepository<Example, Integer> {

  /**
   * Find by user name.
   *
   * @param userName the user name
   * @return the example
   */
  Example findByUserName(String userName);

  /**
   * Delete by id.
   *
   * @param id the id
   */
  void deleteById(long id);

  /**
   * Gets the reference by id.
   *
   * @param id the id
   * @return the reference by id
   */
  Example getReferenceById(Long id);
}
