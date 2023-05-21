package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // MVC와 템플릿 엔진 -> 역할과 기능을 분리
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") // API 방식
    @ResponseBody // @ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 대신에 HTTP의 BODY에 문자 내용을 직접 반환(HTML BODY TAG를 말하는 것이 아님)
    }

    @GetMapping("hello-api") // API 방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
//        @ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨 -> {"name":"spring!!!!"}
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
