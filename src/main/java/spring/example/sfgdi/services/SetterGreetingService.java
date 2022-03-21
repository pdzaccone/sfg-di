package spring.example.sfgdi.services;

import org.springframework.stereotype.Service;

public class SetterGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello world from setter!";
	}
}
