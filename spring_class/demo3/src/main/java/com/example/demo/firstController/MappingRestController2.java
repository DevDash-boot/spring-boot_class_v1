package com.example.demo.firstController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// IoC (제어의 역전 : 실행의 제어권을 개발자로부터 프레임워크로 넘기는 것)
@RestController
public class MappingRestController2 {

    @GetMapping("/books")
    public List<BookDTO> books() {
        return List.of(
                new BookDTO(1, "자바 프로그래밍", "홍길동", 30000),
                new BookDTO(2, "스프링 입문", "김민수", 28000)
        );
    }

    @GetMapping("/books/{id}")
    public String findId(@PathVariable Integer id){
        return id + "번 조회";
    }

    @GetMapping("/books/search")
    public String search(@RequestParam String keyword){
        return "검색어 : " + keyword;
    }

    @Data
    @AllArgsConstructor
    public static class BookDTO{
        private Integer id;
        private String title;
        private String author;
        private Integer price;
    }

    @PostMapping("/books")
    public List<BookDTO> books2 () {
        return List.of(
                new BookDTO(1, "자바 프로그래밍", "홍길동", 30000),
                new BookDTO(2, "스프링 입문", "김민수", 28000)
        );
    }

    @PostMapping("/books/{id}/update")
    public String update(@PathVariable Integer id, BookDTO bookDTO){
        return "수정할 책 id : " + id + "수정할 책 제목 : " + bookDTO.getTitle();
    }

    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable Integer id, BookDTO bookDTO){
        return "삭제할 책 id : " + id + "삭제할 책 제목 : " + bookDTO.getTitle();
    }
}
