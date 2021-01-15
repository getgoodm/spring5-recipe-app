package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5RecipeAppApplication {

	public static void main(String[] args) {
		System.setProperty("javax.xml.bind.JAXBContextFactory", "com.sun.xml.bind.v2.ContextFactory");

		SpringApplication.run(Spring5RecipeAppApplication.class, args);
	}
}
