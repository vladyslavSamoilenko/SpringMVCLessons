package com.samoilenko.springCourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        model.addAttribute("message", "Hello, " + name + " " + surname);
        //System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return  "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) String a,
                             @RequestParam(value = "b", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        if (action.equals("multiplication")){
            model.addAttribute("message", a + " * " + b + " = " + (Double.parseDouble(a)*Double.parseDouble(b)));
        } else if (action.equals("division")) {
            model.addAttribute("message", a + " / " + b + " = " + (Double.parseDouble(a)/Double.parseDouble(b)));

        } else if (action.equals("additional")) {
            model.addAttribute("message", a + " + " + b + " = " + (Double.parseDouble(a)+Double.parseDouble(b)));
        } else if (action.equals("substraction")) {
            model.addAttribute("message", a + " - " + b + " = " + (Double.parseDouble(a)-Integer.parseInt(b)));
        }else {
            model.addAttribute("message", "Wrong action");
        }

        return "first/calculator";
    }
}
