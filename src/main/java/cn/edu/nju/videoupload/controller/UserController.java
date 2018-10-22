package cn.edu.nju.videoupload.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration

public class UserController {
    @RequestMapping("/tryLogin")
    @ResponseBody
    String home() {
        return "Hello ,spring boot!";
    }
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");



    }

}
