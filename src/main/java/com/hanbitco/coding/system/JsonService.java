package com.hanbitco.coding.system;

import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.Map;


@Service
public class JsonService {
  public Map parseJsonFile (String filename) {
    try {
      return (Map)(new JSONParser()).parse(new FileReader(filename));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}