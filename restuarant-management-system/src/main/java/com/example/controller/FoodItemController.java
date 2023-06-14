package com.example.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.FoodItem;
import com.example.repository.FoodItemRepository;
import com.example.service.FoodItemDaoImpl;

@RestController
public class FoodItemController {
	
	
	
	@Autowired
	FoodItemDaoImpl foodItemDaoImpl;
	
	
	@GetMapping("/homePage")
	public ModelAndView gethomePage(Model model) {
		ModelAndView mv=new ModelAndView("homePage");
		mv.addObject(foodItemDaoImpl.showAllItems());
		return mv;
	}
	
	
	
	@GetMapping("/insertItemPage")
	public ModelAndView insertItemPage() {
		ModelAndView mv = new ModelAndView("insertItemPage");
		mv.addObject("insert", foodItemDaoImpl);
		return mv;
	}
	/*
	@GetMapping("/edit/{itemNumber")
	public ModelAndView editItem() {
		ModelAndView mv = new ModelAndView("editItemPage");
		//mv.addObject("fitem", )
	}
	*/
	/*
	@GetMapping("/delete/{itemNumber")
	public ModelAndView deleteItem() {
		foodItemDaoImpl.deleteItem(itemNumber);
		
	}
	*/
	
	
	

}
