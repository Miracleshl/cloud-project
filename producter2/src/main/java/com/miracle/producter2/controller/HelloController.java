package com.miracle.producter2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * Simple Class description.
 *
 * @author SHL
 * @version 1.0
 * @date 2020/9/4
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello consul two";
    }
}
