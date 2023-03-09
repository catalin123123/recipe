package com.catalin.rosu.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Recipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	public Recipe(String name, List<String> ingredients, int noOfServings, boolean isVegetarian) {
		super();

		this.name = name;
		this.ingredients = ingredients;
		this.noOfServings = noOfServings;
		this.isVegetarian = isVegetarian;
	}

	public Recipe()
	{
		super();
		this.name = "default";
		this.ingredients = new ArrayList(List.of(""));
		this.noOfServings = 1;
		this.isVegetarian = true;
	}
	private String name;
	List<String> ingredients;
	private int noOfServings;
	private boolean isVegetarian;

}
