package io.github.i_grr.api.orange.talents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiOrangeTalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOrangeTalentsApplication.class, args);
	}

}
