package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Drink;

@Component
@SessionScope
public class Cart {
	// 商品リスト
	private List<Drink> drink = new ArrayList<>();

	// 商品リストゲッター
	public List<Drink> getDrink() {
		return drink;
	}

	// 合計金額取得用ゲッター
	public int getTotalPrice() {
		// 合計金額
		int total = 0;
		for (Drink drink : drink) {
			total += drink.getPrice() * drink.getQuantity();
		}
		return total;
	}

	// カート追加
	public void add(Drink newDrink) {
		Drink existsDrink = null;
		// 現在のカートの商品から同一IDの商品を探す
		for (Drink drink : drink) {
			if (drink.getId() == newDrink.getId()) {
				existsDrink = drink;
				break;
			}
		}

		// カート内に商品が存在しなかった場合はカート追加
		// 存在した場合は、個数の更新を行う
		if (existsDrink == null) {
			drink.add(newDrink);

		} else {
			existsDrink.setQuantity(
					existsDrink.getQuantity() + newDrink.getQuantity());
		}
	}

	public void delete(int id) {
		for (Drink drink : drink) {
			if (drink.getId() == id) {
				this.drink.remove(drink);
				break;
			}
		}

	}

	public void clear() {
		drink = new ArrayList<>();

	}
}
