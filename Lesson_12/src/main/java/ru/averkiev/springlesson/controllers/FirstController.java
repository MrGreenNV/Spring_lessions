package ru.averkiev.springlesson.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model) {
        String res;

        switch (action) {
            case "multiplication" -> res = (a * b) + "";
            case "addition" -> res = (a + b) + "";
            case "subtraction" -> res = (a - b) + "";
            case "division" -> res = (b != 0 ? (double) a / b : Double.MAX_VALUE) + "";
            default -> res = "Wrong action!";
        }

        model.addAttribute("result", res);


        return "first/calculator";
    }
}