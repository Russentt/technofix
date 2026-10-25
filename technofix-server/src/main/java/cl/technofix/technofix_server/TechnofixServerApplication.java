package cl.technofix.technofix_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cl.technofix")
public class TechnofixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnofixServerApplication.class, args);
	}

}
