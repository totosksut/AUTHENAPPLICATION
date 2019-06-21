package com.example.authen.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuctionController {
	@RequestMapping("/")
    String index() {
        return "Welcome to our auction!";
    }
}
