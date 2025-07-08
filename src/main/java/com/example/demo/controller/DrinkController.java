package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Drink;
import com.example.demo.repository.DrinkRepository;

@Controller
public class DrinkController {

	@Autowired
	DrinkRepository drinkRepository;

	@GetMapping("/drink")
	public String drink(Model model) {

		List<Drink> DrinkList = drinkRepository.findAll();
		model.addAttribute("drink", DrinkList);

		return "drink";
	}
}
