package spring.example.sfgdi.config;

import com.spring.pet.PetService;
import com.spring.pet.PetServiceFactory;
import org.springframework.context.annotation.*;
import spring.example.sfgdi.repositories.EnglishGreetingRepository;
import spring.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import spring.example.sfgdi.services.*;

@ImportResource("classpath:spring-config.xml")
@Configuration
public class GreetingServiceConfig {

	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}

	@Profile({"dog", "default"})
	@Bean
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("dog");
	}

	@Profile({"cat"})
	@Bean
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("cat");
	}

//	@Bean
//	ConstructorGreetingService constructorGreetingService() {
//		return new ConstructorGreetingService();
//	}

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
