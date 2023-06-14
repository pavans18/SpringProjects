package com.example.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.FoodItem;

@Repository
public interface FoodItemDao {
	
	public List<FoodItem> showAllItems();
	
	public void saveItem(FoodItem foodItem);
	
	public FoodItem findItem(String itemNumber);
	
	public void deleteItem(FoodItem foodItem);
	
	public void editItem(FoodItem foodItem);
	
	public FoodItem generateItemId();


}
