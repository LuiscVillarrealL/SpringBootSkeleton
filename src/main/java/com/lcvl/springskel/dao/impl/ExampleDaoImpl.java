package com.lcvl.springskel.dao.impl;

import com.lcvl.springskel.dao.ExampleDao;
import com.lcvl.springskel.model.Example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class ExampleDaoImpl.
 */
@Repository
@Slf4j
@PropertySource("classpath:queries.properties")
public class ExampleDaoImpl implements ExampleDao {

  /** The entity manager. */
  private final EntityManager entityManager;

  /** The env. */
  @Autowired
  Environment env;

  /**
   * Instantiates a new example dao impl.
   *
   * @param entityManager the entity manager
   */
  @Autowired
  public ExampleDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /**
   * Find all.
   *
   * @return the list
   */
  @Override
  public List<Example> findAll() {

    log.info("Finding all example DAO");
    Session currentSession = entityManager.unwrap(Session.class);

    Query<Example> query = currentSession.createQuery(env.getProperty("example.findAll"),
        Example.class);

    return query.getResultList();
  }

  /**
   * Find by id.
   *
   * @param id the id
   * @return the example
   */
  @Override
  public Example findById(int id) {

    Session currentSession = entityManager.unwrap(Session.class);

    return currentSession.get(Example.class, id);
  }


  /**
   * Save.
   *
   * @param example the example
   */
  @Override
  public void save(Example example) {
    Session currentSession = entityManager.unwrap(Session.class);

    currentSession.merge(example);
  }

  /**
   * Delete by id.
   *
   * @param id the id
   */
  @Override
  public void deleteById(int id) {
    // TODO Auto-generated method stub

    Example ex = new Example();
    Session currentSession = entityManager.unwrap(Session.class);

    ex = currentSession.find(Example.class, id);
    entityManager.remove(ex);
    flushAndClear();

  }

  /**
   * Flush and clear.
   */
  void flushAndClear() {
    entityManager.flush();
    entityManager.clear();
  }

  /**
   * Find by username.
   *
   * @param username the username
   * @return the example
   */
  @Override
  public Example findByUsername(String username) {

    Session currentSession = entityManager.unwrap(Session.class);

    Query<Example> query = currentSession.createQuery(env.getProperty("example.findByUser"),
        Example.class);
    query.setParameter("username", username);

    return query.getSingleResult();
  }

}
