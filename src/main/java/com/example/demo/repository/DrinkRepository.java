package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {

	List<Drink> findByNameContaining(String keyword);

	List<Drink> findByNameContainingAndPriceLessThanEqual(String keyword, Integer maxPrice);

	List<Drink> findByPriceLessThanEqual(Integer maxPrice);

	List<Drink> findByNameContainingAndPriceLessThanEqualAndCategoryContaining(String keyword, Integer maxPrice,
			String categories);

	List<Drink> findByCategoryContaining(String categories);

}
