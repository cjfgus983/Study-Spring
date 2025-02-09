package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // 웹에서 /hello로 들어오면 아래가 실행
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "hello"; // 리턴 헬로는 hello.html로 이동할 수 있게 해주는거 // 이 화면을 실행시켜라
    }
}
