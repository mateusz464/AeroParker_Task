package com.example.registration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping("/registration")
    public String getRegistrationPage() {
        return "Register here";
    }

}
