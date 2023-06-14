package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entity.FoodItem;
import com.example.service.FoodItemDaoImpl;



@SpringBootApplication
public class RestaurantApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext =
					SpringApplication.run(RestaurantApplication.class, args);
		
		/*
		FoodItem foodItem = new FoodItem();
		
		foodItem.setItemNumber(101);
		foodItem.setItemName("Biryani");
		foodItem.setCuisine("Indian");
		foodItem.setPrice(250.00);
		foodItem.setAvailability("YES");
		
		FoodItemDaoImpl foodItemDaoImpl = applicationContext.getBean(FoodItemDaoImpl.class);
		
		foodItemDaoImpl.saveItem(foodItem);
		*/
		
	}
	
}
