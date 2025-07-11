package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.model.Cart;
import com.example.demo.model.UsersAccount;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.UsersRepository;

@Controller
public class CartController {
	@Autowired
	DrinkRepository drinkRepository;
	@Autowired
	Cart cart;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersAccount usersAccount;

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

		//		List<Users> user = usersRepository.findByName(usersAccount.setName(name));
		//		Users users1 = user.get(0);
		//		usersAccount.setAddress(users1.getAddress());
		//		usersAccount.setEmail(users1.getEmail());

		return "redirect:/cart";
	}

	@PostMapping("/cart/delete")
	public String deleteCart(@RequestParam("id") int id) {
		cart.delete(id);
		return "redirect:/cart";
	}
}
