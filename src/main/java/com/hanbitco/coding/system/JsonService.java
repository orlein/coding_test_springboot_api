package com.hanbitco.coding.system;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


@Service
public class JsonService {

  private Map _json;
  private static Logger log = LoggerFactory.getLogger(JsonService.class);

  private Map parseJsonFileFromResource (String fileName) {
    try {
      String filepath = (new ClassPathResource(fileName)).getPath();
      log.info("get json file from: {}", filepath);
      BufferedReader br = new BufferedReader(new FileReader(filepath));
      Gson gson = new Gson();
      _json = gson.fromJson(br, HashMap.class);
      return _json;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public Map getSerializedMapFromFile() {
    String _fileName = "price.json";
    Map json;
    if (null == _json || _json.isEmpty()) {
      log.info("get json from method");
      json = parseJsonFileFromResource(_fileName);
    } else {
      log.info("get json from member");
      json = _json;
    }

    return json;
  }






}