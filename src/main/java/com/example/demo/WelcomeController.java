package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @RequestMapping("/welcome")
    public String welcome() {
        return service.getWelcomeMessage();
    }
}

//Sprint to manage this bean
@Component
class WelcomeService{
    public String getWelcomeMessage(){
        return "Hello from Service";
    }
}