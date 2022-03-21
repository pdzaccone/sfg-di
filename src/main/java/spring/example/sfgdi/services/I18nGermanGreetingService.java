package spring.example.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nGermanGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hallo Welt auf Deutsch!";
	}
}