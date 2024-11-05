package com.teste.example.api_atendimento.models;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Agente {

	private String nome;
	private int capacidadeMax;
	private int atendimentoAtual;
	private boolean ocupado;
	
	public Agente(String nome, int capacidadeMax) {
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.atendimentoAtual = 0; 
        this.ocupado = false; 
    }

     public Agente(String nome) {
        this(nome, 1); 
    }
	public String getNome() {
		return nome;
	}

	public boolean isAvailable() {
		return !isOcupado() && atendimentoAtual < capacidadeMax;
	}

	public void assignRequest() {
		if (atendimentoAtual < capacidadeMax) {
			incrementarAtendimentos();
			setOcupado(true);
			System.out.println("Atendente " + getNome() + " iniciou um atendimento. Tempo estimado: 30 segundos.");

 			ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.schedule(this::finishRequest, 30, TimeUnit.SECONDS);
		} else {
			System.out.println("Atendente " + getNome() + " já está no máximo de atendimentos.");
		}
	}

	public void finishRequest() {
		decrementarAtendimentos();
		setOcupado(false);
		System.out.println("Atendente " + getNome() + " terminou um atendimento e está disponível.");
	}

	private void incrementarAtendimentos() {
		atendimentoAtual++;
	}

 	private void decrementarAtendimentos() {
		if (atendimentoAtual > 0) {
			atendimentoAtual--;
		}
	}

	public int getCurrentRequests() {
		return atendimentoAtual;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}