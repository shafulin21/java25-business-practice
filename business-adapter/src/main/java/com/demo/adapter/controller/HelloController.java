package com.demo.adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.demo.adapter.controller
 * Description:
 *
 * @author ayp
 * @version 1.0
 * @since 2025/12/25 16:54
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Java 25 Multi-Module!";
    }
}
