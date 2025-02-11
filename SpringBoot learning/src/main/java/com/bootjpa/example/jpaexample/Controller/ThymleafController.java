package com.bootjpa.example.jpaexample.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;


@Controller
public class ThymleafController {

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(Model model) {

        model.addAttribute("name","Nikhil Butle");

        model.addAttribute("date",new Date().toString());

        return "about";
    }

    @GetMapping(value = "/iterate-example")
    public  String view(Model model){
        List<String> names = List.of("Nikhil","Viraj","Sujal","Nachiket");
        model.addAttribute("names", names);
        return "iterate";
    }

    @GetMapping(value = "/condition")
    public  String condition(Model model){

        model.addAttribute("isActive",false);
        model.addAttribute("Gender",'F');

        List<Integer> list =List.of();

        model.addAttribute("list",list);

        return "condition";
    }
}
