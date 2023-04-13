package com.lcvl.springskel.repository;

import com.lcvl.springskel.model.ExampleOneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface ExampleOneToOneRepo.
 */
public interface ExampleOneToOneRepo extends JpaRepository<ExampleOneToOne, Long> {


  /**
   * Delete by id.
   *
   * @param id the id
   */
  void deleteById(long id);
  
  /**
   * Delete by example id.
   *
   * @param id the id
   */
  void deleteByExampleId(Long id);

  /**
   * Gets the reference by id.
   *
   * @param id the id
   * @return the reference by id
   */
  ExampleOneToOne getReferenceById(Long id);
  
}
