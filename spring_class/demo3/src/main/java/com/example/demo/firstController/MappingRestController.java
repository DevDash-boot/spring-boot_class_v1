package com.example.demo.firstController;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// IoC (제어의 역전 : 실행의 제어권을 개발자에게서부터 프레임워크로 넘기는 것)
@RestController
public class MappingRestController {
    // 1. 기본
    // 주소 설계 : GET - http://localhost:8080/hi
    @GetMapping("/hi")
    public String hi(){
        return "홍길동 : 안녕하세요";
    }

    // 2. 객체를 반환하는 응답을 만들어보기
    // 주소 설계 : GET - http://localhost:8080/user-info
    @GetMapping("/user-info")
    public Map<String, Object> userInfo(){
        // Map.of() : 불변 객체를 만들어주는 함수
        // 스프링 프레임워크 내부에 있는 메세지 컴퍼터라는 녀석이 알아서 JSON 형식으로 반환 해줌.
        return Map.of("name", "김민수", "age", 20);
    }

    // 3. 경로 변수 : 특정 대상 하나를 가리킬 때 사용
    // 주소 설계 : GET - http://localhost:8080/users/101
    @GetMapping("/users/{userId}")
    public String findUser(@PathVariable Long userId){
        System.out.printf("경로 변수 확인 : " + userId);
        return userId + "번 사용자 조회(DB는 나중)";
    }

    // 4. 쿼리 파라미터 : 목록을 거르거나 옵션을 줄 때 사용
    // ?는 첫 시작, 여러 개를 받을 경우 &을 사용
    // 주소 설계 : GET - http://localhost:8080/search?keyword=스프링&page=2
    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "1") Integer page){
        return "검색어 : " + keyword + ", 페이지 : " + page;
    }

    // 5. 폼 데이터 : 여러 값을 보통 DTO 객체를 설계해서 동작하는 객체로 만들어 받는다.
    // 어노테이션 없이 파라미터에 클래스 이름을 적기만 하면 요청의 이름과 같은 필드에 스프링이 값을 넣어준다.
    // 주소 설계 : POST - http://localhost:8080/users (username=김민수, email=a@naver.com)
    @PostMapping("/users")
    // new UserJoinDTO 한 적이 없는데 동작 -> 스프링 프레임워크가 일함.
    // 메시지 컨버터가 http 구문을 분석하고 자동으로 객체를 생성한 후에 이름이 같은 필드에 값을 넣고 있다.
    public String join(UserJoinDTO joinDTO){
        return joinDTO.getUsername() +"님 가입 요청을 받음, " + joinDTO.getEmail();
    }
    @Data
    public static class UserJoinDTO{
        private String username;
        private String email;
    }
}
