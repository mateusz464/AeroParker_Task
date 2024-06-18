package com.example.registration.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/submitRegistration")
    public String submitRegistration(
            @RequestParam("title") String title,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("address1") String address1,
            @RequestParam(value = "address2", required = false) String address2,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam("postcode") String postcode,
            @RequestParam(value = "countryCode", required = false) String countryCode,
            @RequestParam(value = "phone", required = false) String phone
    ) {
        System.out.println("Title: " + title);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Address Line 1: " + address1);
        System.out.println("Address Line 2: " + address2);
        System.out.println("City: " + city);
        System.out.println("Postcode: " + postcode);
        System.out.println("Phone Number: +" + countryCode + phone);
        return "registration";
    }
}
