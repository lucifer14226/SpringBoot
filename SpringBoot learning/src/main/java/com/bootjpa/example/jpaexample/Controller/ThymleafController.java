package com.bootjpa.example.jpaexample.Controller;

import com.bootjpa.example.jpaexample.model.LoginData;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "/form")
    public String openForm(Model model){

        model.addAttribute("loginData", new LoginData());
        return "form";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData")LoginData loginData, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "form";
        }

        System.out.println(loginData.getUserName());
        System.out.println(loginData.getEmail());
        return "success";
    }
}
