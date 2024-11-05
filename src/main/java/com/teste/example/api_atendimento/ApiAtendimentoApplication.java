package com.teste.example.api_atendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Habilita o agendamento de tarefas
public class ApiAtendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAtendimentoApplication.class, args);
	}

}
