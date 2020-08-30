package de.fak73.coronaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

    @GetMapping("/")
    public ResponseEntity<String> getApiFeedback() {
        return new ResponseEntity<>("this is the corona-spring-boot-api v0.1", HttpStatus.OK);
    }
    
}