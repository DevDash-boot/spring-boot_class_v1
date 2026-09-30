package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller : 리턴 타입에 반환한 타입이 문자열이라면 화면 파일(템플릿) 이름으로 해석한다.
// IoC(제어의 역전) : 프레임워크가 어노테이션을 확인한 후 메모리 공간에 객체를 미리 생성해둔다.
@Controller
public class MappingController2 {
    // 주소 설계 : GET - http://localhost:8080/homepage
    // templates/index.mustache 파일을 찾아서 HTML 파일로 응답한다.
    // resources/templates 폴더 내에 index.mustache 파일을 만든다.
    @GetMapping("/homepage")
    public String hompage(){
        return "index";
    }
}
