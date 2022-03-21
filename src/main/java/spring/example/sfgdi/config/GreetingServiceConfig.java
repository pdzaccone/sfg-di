package spring.example.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.example.sfgdi.services.ConstructorGreetingService;
import spring.example.sfgdi.services.PropertyGreetingService;
import spring.example.sfgdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {

	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}

	@Bean
	PropertyGreetingService propertyGreetingService() {
		return new PropertyGreetingService();
	}

	@Bean
	SetterGreetingService setterGreetingService() {
		return new SetterGreetingService();
	}
}
