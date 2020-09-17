package br.com.bv.apiProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CheckInAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckInAppApplication.class, args);
	}

}
