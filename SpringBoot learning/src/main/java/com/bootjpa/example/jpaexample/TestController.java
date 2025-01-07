package com.bootjpa.example.jpaexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        int a=82;
        int b=39;
        int c=38;
        return "this is just for test purpose sum of a and b "+ (a+b+c);
    }

}
