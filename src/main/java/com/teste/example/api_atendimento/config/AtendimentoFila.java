package com.teste.example.api_atendimento.config;

import java.util.LinkedList;
import java.util.Queue;

import com.teste.example.api_atendimento.models.Atendimento;

public class AtendimentoFila {
    private Queue<Atendimento> fila = new LinkedList<>();

    public void enqueue(Atendimento atend) {
        fila.add(atend);
    }

    public Atendimento dequeue() {
        return fila.poll();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}