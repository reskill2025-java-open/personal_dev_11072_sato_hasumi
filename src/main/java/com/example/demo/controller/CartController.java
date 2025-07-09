package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.model.Cart;
import com.example.demo.repository.DrinkRepository;

@Controller
public class CartController {
	@Autowired
	DrinkRepository drinkRepository;
	@Autowired
	Cart cart;

	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("id") Integer id) {
		Drink drink = drinkRepository.findById(id).get();
		drink.setQuantity(1);
		cart.add(drink);

		return "redirect:/cart";
	}
}
