package dio.exercicio.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonApplication implements CommandLineRunner {

	@Autowired
	private ConfigManager configManager;

	public static void main(String[] args) {
		SpringApplication.run(SingletonApplication.class, args);
	}

	@Override
	public void run(String... args) {
		configManager.setConfig("theme", "dark");
		System.out.println(configManager.getConfig("theme"));

		// Saída: dark
	}
}
