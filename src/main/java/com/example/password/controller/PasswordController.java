package com.example.password.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.password.service.PasswordService;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @GetMapping("/generate")
    public String generate(@RequestParam(defaultValue = "12") int length) {
        return PasswordService.generatePassword(length);
    }

    @PostMapping("/validate")
    public String validate(@RequestBody String password) {
        return PasswordService.validatePassword(password);
    }
}
