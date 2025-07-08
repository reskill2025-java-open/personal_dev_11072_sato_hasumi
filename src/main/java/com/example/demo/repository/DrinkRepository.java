package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {

	List<Drink> findByNameContaining(String keyword);

}
