package br.n2.picpay.desafio_pp_n2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class DesafioPpN2Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPpN2Application.class, args);
	}

}
