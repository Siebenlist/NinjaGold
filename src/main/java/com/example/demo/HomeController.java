package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	private int totalGold = 0;

	private ArrayList<String> activities = new ArrayList<String>();
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("totalGold", totalGold);
		model.addAttribute("activities", activities);
		return "home";
	}
	
	@PostMapping("/farm")
	public String farm() {
		int newGold = new Random().nextInt(11)+10;
		totalGold += newGold;
		activities.add("You entered a farm and earned " + newGold + " gold " + "(" + LocalDateTime.now() + ")");
		return "redirect:/";
	}
	
	@PostMapping("/cave")
	public String cave() {
		int newGold = new Random().nextInt(6)+5;
		totalGold += newGold;
		activities.add("You entered a cave and earned " + newGold + " gold " + "(" + LocalDateTime.now() + ")");
		return "redirect:/";
	}
	
	@PostMapping("/house")
	public String house() {
		int newGold = new Random().nextInt(3)+3;
		totalGold += newGold;
		activities.add("You entered a house and earned " + newGold + " gold " + "(" + LocalDateTime.now() + ")");
		return "redirect:/";
	}
	
	@PostMapping("/casino")
	public String casino() {
		int newGold = new Random().nextInt(101)-50;
		totalGold += newGold;
		activities.add("You entered a casino and " + ((newGold > 0) ? ("earned " + newGold) : ("lost " + newGold)) + " gold (" + LocalDateTime.now() + ")");
		return "redirect:/";
	}
	
	@PostMapping("/reset")
	public String reset() {
		totalGold = 0;
		activities.add("You used the reset button and now your gold has been restablished.");
		return "redirect:/";
	}
}
