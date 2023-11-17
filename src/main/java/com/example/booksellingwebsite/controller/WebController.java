package com.example.booksellingwebsite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String getHome() {
        return "web/index";
    }

    @GetMapping("/shop")
    public String getShop() {
        return "web/shop";
    }

//    @GetMapping("/")
//    public String getDetailProduct() {
//        return "web/index";
//    }





}
