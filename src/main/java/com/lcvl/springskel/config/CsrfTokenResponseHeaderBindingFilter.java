package com.lcvl.springskel.config;

import java.io.IOException;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CsrfTokenResponseHeaderBindingFilter.
 */
public class CsrfTokenResponseHeaderBindingFilter extends OncePerRequestFilter {
  
  /** The Constant REQUEST_ATTRIBUTE_NAME. */
  protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
  
  /** The Constant RESPONSE_HEADER_NAME. */
  protected static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
  
  /** The Constant RESPONSE_PARAM_NAME. */
  protected static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
  
  /** The Constant RESPONSE_TOKEN_NAME. */
  protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";

  /**
   * Do filter internal.
   *
   * @param request the request
   * @param response the response
   * @param filterChain the filter chain
   * @throws ServletException the servlet exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    CsrfToken token = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);

    if (token != null) {
      response.setHeader(RESPONSE_HEADER_NAME, token.getHeaderName());
      response.setHeader(RESPONSE_PARAM_NAME, token.getParameterName());
      response.setHeader(RESPONSE_TOKEN_NAME, token.getToken());
    }

    filterChain.doFilter(request, response);
  }
}
