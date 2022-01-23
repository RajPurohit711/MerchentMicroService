package com.example.SpringAuthentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home()
    {
        return "my Home Page";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "this is admin page";
    }
}
