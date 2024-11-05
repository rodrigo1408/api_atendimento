package com.teste.example.api_atendimento.models;

public class Atendimento {
	private String assunto;
	private String descricao;

	private Atendimento() {
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
 
}
