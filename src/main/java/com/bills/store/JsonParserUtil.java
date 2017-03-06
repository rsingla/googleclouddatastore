package com.bills.store;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonParserUtil {

  public static <T> String seralizeObject(T object, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      return mapper.writeValueAsString(object);
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static <T> T getPojo(String json, Class<T> clazz) {

    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    T pojo = null;
    try {
      pojo = mapper.readValue(new String(json), clazz);
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    return pojo;
  }

}
