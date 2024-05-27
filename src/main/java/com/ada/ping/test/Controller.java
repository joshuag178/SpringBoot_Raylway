package com.ada.ping.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @GetMapping("/ping")
        public String ping(){
        return "Hello World";
    }

    @RequestMapping("/hello")
        public String report(@RequestParam(defaultValue = "World") String name){
        return "<h1>Hello " + name+"</h1>";
    }

    @GetMapping("/name")
    public String name(){
        return "<h1>Hello Josué García</h1>";
    }

    @RequestMapping("/dog")
    public String consumeResource(){
        RestTemplate restTemplate = new RestTemplate();
        String apiURL = "https://dog.ceo/api/breeds/list/all";
        return restTemplate.getForObject(apiURL, String.class);
    }
}
