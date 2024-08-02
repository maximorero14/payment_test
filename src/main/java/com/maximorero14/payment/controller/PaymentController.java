package com.maximorero14.payment.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/users")
    public String getUsers() {
        String userServiceUrl = "http://user-test-service:8080/user/all";
        return restTemplate.getForObject(userServiceUrl, String.class);
    }
}
