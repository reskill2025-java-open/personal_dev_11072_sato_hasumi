package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.repository.DrinkRepository;

@Controller
public class DrinkController {

	@Autowired
	DrinkRepository drinkRepository;

	@GetMapping("/drink")
	public String drink(
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			Model model) {

		List<Drink> DrinkList = drinkRepository.findAll();
		model.addAttribute("drink", DrinkList);

		List<Drink> drinkList = null;
		if (keyword.length() > 0) {
			drinkList = drinkRepository.findByNameContaining(keyword);
			model.addAttribute("keyword", keyword);
		}

		return "drink";
	}

	@GetMapping("/drink/{id}")
	public String individual(@PathVariable("id") Integer id, Model model) {
		//主キーで検索するとき以下のように書く
		Drink drink = drinkRepository.findById(id).get();
		model.addAttribute("drink", drink);
		return "shousai";
	}

}
