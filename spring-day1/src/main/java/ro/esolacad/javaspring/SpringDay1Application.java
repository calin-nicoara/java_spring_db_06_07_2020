package ro.esolacad.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import ro.esolacad.outside.OutsideConfiguration;

@SpringBootApplication
@EnableAsync
@Import(OutsideConfiguration.class)
public class SpringDay1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDay1Application.class, args);
	}

}
