package com.example.barcode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/main")
public class MainController {

    @RequestMapping("/")
    public ResponseEntity helloWorld() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "HELLO WORLD!!!");

        return ResponseEntity.ok(response);
    }

}
