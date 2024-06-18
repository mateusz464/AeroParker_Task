package com.example.registration.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // Validation
        String[] fieldsToValidate = {title, firstName, lastName, email, address1, postcode};
        String[] fieldNames = {"title", "firstName", "lastName", "email", "address1", "postcode"};
        for (int i = 0; i < fieldsToValidate.length; i++) {
            if (fieldsToValidate[i] == null || fieldsToValidate[i].isEmpty()) {
                // Redirect to the registration page with an error message
                return "redirect:/registration?error=" + fieldNames[i];
            }
        }

        // Ensure email is valid
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return "redirect:/registration?error=email";
        }

        // Remove case sensitivity from the email
        email = email.toLowerCase();



        return "registration";
    }
}
