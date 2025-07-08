package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.DrinkRepository;

@Controller
public class cart {
	@Autowired
	DrinkRepository drinkRepository;

	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
}
