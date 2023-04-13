package com.lcvl.springskel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ExampleOneToOne.
 */
@ToString
@Getter
@Setter
@Entity(name = "example_one_to_one")
@NoArgsConstructor
@AllArgsConstructor
public class ExampleOneToOne {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
  @MapsId
  @JoinColumn(name = "example_id")
  private Example example;

}
