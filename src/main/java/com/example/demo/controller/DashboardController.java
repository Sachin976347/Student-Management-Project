package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/attendance")
    public String attendance() {
        return "attendance";
    }

    @GetMapping("/fees")
    public String fees() {
        return "fees";
    }

    @GetMapping("/exams")
    public String exams() {
        return "exams";
    }

    @GetMapping("/transport")
    public String transport() {
        return "transport";
    }

    @GetMapping("/library")
    public String library() {
        return "library";
    }

    @GetMapping("/hostel")
    public String hostel() {
        return "hostel";
    }

    @GetMapping("/id-card")
    public String idCard() {
        return "id-card";
    }

    @GetMapping("/homework")
    public String homework() {
        return "homework";
    }
}