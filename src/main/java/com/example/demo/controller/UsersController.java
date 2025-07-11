package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.model.UsersAccount;
import com.example.demo.repository.UsersRepository;

@Controller
public class UsersController {

	@Autowired
	HttpSession session;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersAccount usersAccount;

	@GetMapping("/login")
	public String login() {

		session.invalidate();
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "email", defaultValue = "") String email,
			Model model) {

		if ((name == null || name.length() == 0) && (password == null || password.length() == 0)) {
			model.addAttribute("message", "名前とパスワードは必須です");
			return "login";
		} else if (name == null || name.length() == 0) {
			model.addAttribute("message1", "名前は必須です");
			return "login";
		} else if (password == null || password.length() == 0) {
			model.addAttribute("message2", "パスワードは必須です");
			return "login";
		}

		usersAccount.setName(name);
		usersAccount.setAddress(address);
		usersAccount.setEmail(email);

		///発送するときの顧客情報
		if (address.equals("")) {
			List<Users> user = usersRepository.findByName(name);
			Users users1 = user.get(0);
			usersAccount.setAddress(users1.getAddress());
			usersAccount.setEmail(users1.getEmail());
		}
		return "redirect:/drink";
	}

	//新規登録途中
	@GetMapping("/login/add")
	public String users() {
		return "loginAdd";
	}

	//	@PostMapping("/login/add")
	//	public String usersnew(
	//			@RequestParam(name = "name", defaultValue = "") String name,
	//			@RequestParam(name = "address", defaultValue = "") String address,
	//			@RequestParam(name = "email", defaultValue = "") String email,
	//			@RequestParam(name = "password", defaultValue = "") String password,
	//			@RequestParam(name = "birthday", defaultValue = "") String birthday,
	//			Model model) {
	//
	//		Users users2 = new Users(name, address, email, password, birthday);
	//		users2.setName(name);
	//		users2.setAddress(address);
	//		users2.setEmail(email);
	//		users2.setPassword(password);
	//		users2.setBirthday(birthday);
	//
	//		usersRepository.save(users2);
	//
	//		List<Users> user = usersRepository.findByName(name);
	//		Users users1 = user.get(0);
	//		usersAccount.setAddress(users1.getAddress());
	//		usersAccount.setEmail(users1.getEmail());
	//
	//		return "redirect:/drink";
	//	}

	// エラーチェック
	//		List<String> errorList = new ArrayList<>();
	//		if (name.length() == 0) {
	//			errorList.add("名前は必須です");
	//		}
	//		if (address.length() == 0) {
	//			errorList.add("住所は必須です");
	//		}
	//		if (password.length() == 0) {
	//			errorList.add("パスワードは必須です");
	//		}
	//		if (email.length() == 0) {
	//			errorList.add("メールアドレスは必須です");
	//		}
	//
	//		// エラー発生時はお問い合わせフォームに戻す
	//		if (errorList.size() > 0) {
	//			model.addAttribute("errorList", errorList);
	//			model.addAttribute("name", name);
	//			model.addAttribute("address", address);
	//			model.addAttribute("password", password);
	//			model.addAttribute("email", email);
	//			model.addAttribute("birthday", birthday);
	//			return "LoginAdd";
}
