package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.model.Cart;
import com.example.demo.model.UsersAccount;
import com.example.demo.repository.UsersRepository;

@Controller
public class OrderController {

	@Autowired
	Cart cart;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersAccount usersAccount;

	@GetMapping("/order")
	public String order(
			@RequestParam(name = "id", defaultValue = "") Integer id,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "email", defaultValue = "") String email,
			Model model) {
		List<Users> users = usersRepository.findByName(name);
		//List<Users>users= usersRepository.findByAddressAndEmail(address)

		model.addAttribute("users", users);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("email", email);

		return "usersForm";
	}

	@GetMapping("/order/confirm")
	public String confirm() {
		return "orderConfirm";
	}

}
