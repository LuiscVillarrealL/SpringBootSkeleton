package com.lcvl.springskel.model;

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
 * The Class example2.
 */
@ToString
@Getter
@Setter
@Entity(name = "example2")
@NoArgsConstructor
@AllArgsConstructor
public class Example2 {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** The user name. */
  @Column(name = "user_name", unique = true)
  private String userName;

  /** The first name. */
  @Column(name = "first_name")
  private String firstName;

  /** The number. */
  @Column(name = "number")
  private int number;

}
