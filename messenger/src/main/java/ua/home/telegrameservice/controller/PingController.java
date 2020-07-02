package ua.home.telegrameservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController
{

    @RequestMapping("/")
    public String index()
    {
        return "Greetings from Spring Boot!1";
    }

}