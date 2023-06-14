package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.FoodItem;
import com.example.repository.FoodItemRepository;

@Repository
@Service
public class FoodItemDaoImpl implements FoodItemDao {
	
	@Autowired
	private FoodItemRepository foodrepo;

	@Override
	public List<FoodItem> showAllItems() {
		
		return foodrepo.findAll();
	}

	@Override
	public void saveItem(FoodItem foodItem) {
		
		foodrepo.save(foodItem);
		
	}

	@Override
	public FoodItem findItem(String itemNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(FoodItem foodItem) {
		foodrepo.delete(foodItem);
		
	}

	@Override
	public void editItem(FoodItem foodItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodItem generateItemId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
