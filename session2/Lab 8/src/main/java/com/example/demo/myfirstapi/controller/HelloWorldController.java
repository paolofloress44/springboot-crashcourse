package com.example.demo.myfirstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value; //import

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Marks this class as a REST controller
public class HelloWorldController {

    @Value("${app.greeting.message}") //inject value
    private String customGreeting;

    @GetMapping("/hello") // Maps HTTP GET requests to the "/hello" URL
    public String sayHello() {
        //return "Hello, Spring Boot Learners!";
        return customGreeting;
    }

    @GetMapping("/greet/{name}") // This path now expects a dynamic 'name' part
    public String greetUser(@PathVariable String name) { // @PathVariable maps the URL part to this parameter
        return "Greetings, " + name + "!";
    }

//    @GetMapping("/greeting")
//    public String greetWithParam(
//            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//        return "Hello, " + name + "!";
//    }
//
//    @GetMapping("/calculate/sum")
//    public String sumNumbers(
//            @RequestParam("num1") int number1,
//            @RequestParam("num2") int number2) {
//        int sum = number1 +
//                number2; return "The sum of " + number1 + " and " +
//                number2 + " is " + sum;
//    }
//
//    @GetMapping("/info")
//    public Map<String, String> getAppInfo() {
//        Map<String, String> info = new HashMap<>();
//        info.put("appName", "MyFirstSpringBootAPI");
//        info.put("version", "1.0.0");
//        info.put("status", "Running");
//        return info;
//    }
//
//    @GetMapping("/features")
//    public List<String> getFeatures() {
//        return Arrays.asList("REST API", "Spring Boot", "Easy Setup", "Fast Development");
//    }

}