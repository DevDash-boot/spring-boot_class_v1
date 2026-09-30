package com.example.demo.LogTestController;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // IoC 대상 + 싱글톤 패턴으로 관리됨
public class LogTestController {

    // GET - http://localhost:8080/log-test
    @GetMapping("log-test")
    public String logTest(){
        log.trace("trace 레벨 - 가장 자세한 주석");
        log.debug("debug 레벨 - 개발 중 확인용");
        log.info("info 레벨 - 일반 실행 정보");
        log.warn("warn 레벨 - 주의가 필요함");
        log.error("error 레벨 - 오류 발생");
        return "서버 컴퓨터의 콘솔을 확인하세요";
    }
}
