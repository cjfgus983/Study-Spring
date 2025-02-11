package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 웹에서 /hello로 들어오면 아래가 실행
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "hello"; // 리턴 헬로는 hello.html로 이동할 수 있게 해주는거 // 이 화면을 실행시켜라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        // "name" 이 키고 name 이 그 값임
        return "hello-template"; // /hello-mvc로 사이트 연결되고 hello-template.html파일로 넘어감
    }

    @GetMapping("hello-string")
    @ResponseBody // http에 해드부분과 바디부분이 있는데 바디부에 데이터를 직접 넣어주겠다라는 것임
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

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
