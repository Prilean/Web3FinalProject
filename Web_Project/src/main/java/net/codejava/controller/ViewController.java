package net.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	@GetMapping("/home")
	public String home() {
		return "website";
	}
	@GetMapping("/lesson")
	public String lesson() {
		return "lessons";
	}
	@GetMapping("/exercise")
	public String exercise() {
		return "Exercise";
	}
	@GetMapping("/contact")
	public String contact() {
		return "Cont";
	}
	@GetMapping("/aboutus")
	public String aboutus() {
		return "Aboutus";
	}
}
