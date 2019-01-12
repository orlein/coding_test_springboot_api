package com.hanbitco.coding.data;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
class DataController {

    @RequestMapping("/data")
    public String welcome() {
        return "Hello world";
    }
}
