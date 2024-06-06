package br.n2.picpay.desafio_pp_n2;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.kafka.config.TopicBuilder;


/**
 * A classe DesafioPpN2Application é a classe principal da aplicação.
 * Ela é responsável por iniciar a aplicação Spring Boot.
 *
 * @EnableJdbcAuditing Habilita a auditoria JDBC para os repositórios.
 * @SpringBootApplication Indica que é uma aplicação Spring Boot.
 */
@EnableJdbcAuditing
@SpringBootApplication
public class DesafioPpN2Application {

	/**
     * O método main inicia a aplicação Spring Boot.
     *
     * @param args Os argumentos da linha de comando.
     */

	public static void main(String[] args) {
		SpringApplication.run(DesafioPpN2Application.class, args);
	}

	/**
     * Cria um novo tópico Kafka chamado "transaction-notification".
     *
     * @return O novo tópico Kafka.
     */
	@Bean
	NewTopic notificationTopic() {
		return TopicBuilder.name("transaction-notification")
				.build();

}
}
