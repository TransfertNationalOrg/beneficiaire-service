package ma.ensa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeneficiaireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaireServiceApplication.class, args);
	}

}
