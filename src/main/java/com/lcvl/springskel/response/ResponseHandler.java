package com.lcvl.springskel.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * The Class ResponseHandler.
 */
public class ResponseHandler {

  /**
   * Generate response.
   *
   * @param responseInfo the response info
   * @param responseObj the response obj
   * @return the response entity
   */
  public static ResponseEntity<Object> generateResponse(ResponseObj responseInfo,
      Object responseObj) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    map.put("message", responseInfo.getMessage());
    map.put("data", responseObj);
    map.put("timestamp", responseInfo.getTimestamp());
    map.put("status", responseInfo.getStatus().value());

    return new ResponseEntity<Object>(map, responseInfo.getStatus());
  }

}
