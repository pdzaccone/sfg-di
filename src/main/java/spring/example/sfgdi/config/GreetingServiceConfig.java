package spring.example.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import spring.example.sfgdi.repositories.EnglishGreetingRepository;
import spring.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import spring.example.sfgdi.services.*;

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

	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}

	@Profile("EN")
	@Bean
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}

	@Profile({"DE", "default"})
	@Bean("i18nService")
	I18nGermanGreetingService i18nGermanGreetingService() {
		return new I18nGermanGreetingService();
	}
}
