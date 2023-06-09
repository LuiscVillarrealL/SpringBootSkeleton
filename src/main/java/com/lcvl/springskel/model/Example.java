package com.lcvl.springskel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class example.
 */
@ToString
@Getter
@Setter
@Entity(name = "example")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Example {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  /** The user name. */
  @Column(name = "user_name", unique = true)
  private String userName;

  /** The first name. */
  @Column(name = "first_name")
  private String firstName;

  /** The number. */
  @Column(name = "number")
  private Long number;

}
