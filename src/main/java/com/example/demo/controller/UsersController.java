package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Controller
public class UsersController {

	@Autowired
	HttpSession session;
	@Autowired
	UsersRepository usersRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {
		//	if (name == null || name.length() == 0) {
		//	model.addAttribute("message", "名前は必須です");
		//return "login";
		//} else
		return "redirect:/drink";
	}

	@GetMapping("/login/add")
	public String users() {
		return "addlogin";
	}

	@PostMapping("/login/add")
	public String usersnew(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("birthday") String birthday,
			Model model) {

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		if (address.length() == 0) {
			errorList.add("住所は必須です");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}

		// エラー発生時はお問い合わせフォームに戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("address", address);
			model.addAttribute("password", password);
			model.addAttribute("email", email);
			model.addAttribute("birthday", birthday);
			return "addLogin";
		}

		Users users = new Users(null, name, address, email, password, birthday, null);
		usersRepository.save(users);

		return "redirect:/drink";
	}

}
