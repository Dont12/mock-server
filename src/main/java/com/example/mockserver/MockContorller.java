package com.example.mockserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockContorller {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
