package com.hanbitco.coding.system;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseBodyService {
    public Map<String, Object> makeResponseBody(Map<String, Object> body) {
        Map<String, Object> result = new HashMap<>();

        result.put("status", "success");
        result.put("data", body);

        return result;
    }
}
