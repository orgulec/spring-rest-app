package pl.sda.springrestapp.springrestapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springrestapp.springrestapp.configuration.CarserviceConfiguration;

@SpringBootApplication
@RequiredArgsConstructor
@OpenAPIDefinition(	//to jest opcjonalny opis do Swaggera!!!
		info = @Info(
				title = "Moja aplikacja",
				version = "1.0.0")
		)
@Slf4j
public class SpringRestAppApplication implements CommandLineRunner {
	public final CarserviceConfiguration carserviceConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		carserviceConfiguration.showCarserviceDataFromProperties();
		log.trace("Logi z poziomu TRACE");
		log.debug("Logi z poziomu DEBUG");
		log.info("Logi z poziomu INFO");
		log.warn("Logi z poziomu WARN");
		log.error("Logi z poziomu ERROR");
	}
}
