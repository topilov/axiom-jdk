package me.func.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestBody byte[] data) {
        return ResponseEntity.ok("Received " + data.length + " bytes");
    }
}
