package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
//    1. 기본적인 방식
//      URL/hello로 접속
//      hello() 실행
//      "data"에 "spring!!" 담고
//      hello.html로 이동
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }
//    2. 조금 개선된 방식
//      URL/hello-mvc로 접속
//      helloMvc() 실행
//      "data"에 "spring!!" 담고
//      hello.html로 이동
    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-templete";
    }
//    3. 뷰 페이지(html 파일)을 아예 생성하는 방식
//      URL/hello-string?name="아무개"로 접속
//      helloString() 실행
//      @ResponseBody: 뷰페이지의 Body값이 리턴값인 페이지를 생성한다.
    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
//    4. 뷰 페이지(html 파일)을 아예 생성하는 방식

//      URL/hello-string?name=(값)로 접속
//      helloApi() 실행
//      @ResponseBody: 뷰페이지의 Body값이 리턴값인 페이지를 생성한다.
    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);    // {"name": (name에 들어간 값)}
        return hello;   // 객체를 JSON 형태로 전달
    }

    // Propertu 접근 방식
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
