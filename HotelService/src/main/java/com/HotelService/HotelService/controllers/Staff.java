package com.HotelService.HotelService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/staff")
public class Staff {
    @GetMapping("/get")
    public ResponseEntity<List<String>> getStaff(){
        List<String> list = Arrays.asList("Ram", "Sham", "Sita");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
