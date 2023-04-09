package com.lcvl.springskel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class CrsfController.
 */
@RestController
@RequestMapping("/api/v1/csrf")
public class CrsfController {

  /**
   * Csrf token.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void csrfToken() {

  }

}
