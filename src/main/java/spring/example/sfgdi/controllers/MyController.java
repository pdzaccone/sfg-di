package spring.example.sfgdi.controllers;

import org.springframework.stereotype.Controller;
import spring.example.sfgdi.services.GreetingService;

@Controller
public class MyController {

	private final GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return this.greetingService.sayGreeting();
	}
}
