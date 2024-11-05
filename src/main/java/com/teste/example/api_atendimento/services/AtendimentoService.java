package com.teste.example.api_atendimento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.example.api_atendimento.config.AtendimentoFila;
import com.teste.example.api_atendimento.models.Agente;
import com.teste.example.api_atendimento.models.Atendimento;

@Service
public class AtendimentoService {

	private List<Agente> cartao = new ArrayList<>();
	private List<Agente> emprestimo = new ArrayList<>();
	private List<Agente> outros = new ArrayList<>();

	private AtendimentoFila cartaoFila = new AtendimentoFila();
	private AtendimentoFila empFila = new AtendimentoFila();
	private AtendimentoFila outroFila = new AtendimentoFila();

	public AtendimentoService() {
		cartao.add(new Agente("Atendente Cartão 1"));
		cartao.add(new Agente("Atendente Cartão 2"));
		cartao.add(new Agente("Atendente Cartão 3"));

		emprestimo.add(new Agente("Atendente Empréstimos 1"));
		emprestimo.add(new Agente("Atendente Empréstimos 2"));
		emprestimo.add(new Agente("Atendente Empréstimos 3"));

		outros.add(new Agente("Atendente Outros 1"));
		outros.add(new Agente("Atendente Outros 2"));
		outros.add(new Agente("Atendente Outros 3"));
	}

	public String distribuirAtendimento(Atendimento atend) {
		String assunto = atend.getAssunto().toLowerCase();

		if (assunto.contains("cartão")) {
			return handleRequest(cartao, cartaoFila, atend, "Cartões");
		} else if (assunto.contains("empréstimo")) {
			return handleRequest(emprestimo, empFila, atend, "Empréstimos");
		} else {
			return handleRequest(outros, outroFila, atend, "Outros Assuntos");
		}
	}

	private String handleRequest(List<Agente> agents, AtendimentoFila fila, Atendimento atend, String team) {
		for (Agente agent : agents) {
			agent.setOcupado(false);
			if (agent.isAvailable()) {
				agent.assignRequest();
				return "A solicitação foi atribuída a " + agent.getNome() + " do time de " + team + ".";
			}
		}
		fila.enqueue(atend);
		return "Todos os atendentes do time de " + team + " estão ocupados. Sua solicitação foi colocada na fila de espera.";
	}

	public void processQueues() {
		processQueue(cartao, cartaoFila);
		processQueue(emprestimo, empFila);
		processQueue(outros, outroFila);
	}

	private void processQueue(List<Agente> agents, AtendimentoFila fila) {
		while (!fila.isEmpty()) {
			for (Agente agent : agents) {
				if (agent.isAvailable()) {
					fila.dequeue();
					agent.assignRequest();
					System.out.println("A solicitação foi retirada da fila e atribuída a " + agent.getNome());
					if (fila.isEmpty()) {
						break;
					}
				}
			}
		}
	}
}
