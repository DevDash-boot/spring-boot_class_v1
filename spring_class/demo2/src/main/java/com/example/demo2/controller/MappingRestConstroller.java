package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingRestConstroller {
    // 1. 주소 설계
    // GET - http://localhost:8080/hi
    @GetMapping("/hi")
    public String hi(){
        return "홍길동 : 안녕하세요";
    }
}
