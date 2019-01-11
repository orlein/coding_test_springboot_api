package com.hanbitco.coding.system;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
class WelcomeController {

    @RequestMapping("/")
    public String welcome() {
        return "Hello world";
    }
}
