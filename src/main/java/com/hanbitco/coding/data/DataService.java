package com.hanbitco.coding.data;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanbitco.coding.system.JsonService;

@Service
public class DataService {

  @Autowired
  JsonService jsonService;
}