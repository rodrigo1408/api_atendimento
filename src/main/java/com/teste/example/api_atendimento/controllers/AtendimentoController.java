package com.teste.example.api_atendimento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.example.api_atendimento.models.Atendimento;
import com.teste.example.api_atendimento.services.AtendimentoService;

@RestController
@RequestMapping("/api")
public class AtendimentoController {

	@Autowired
    private AtendimentoService atendService;

    @PostMapping("/distribuir")
    public String distributeRequest(@RequestBody Atendimento atend) {
        return atendService.distribuirAtendimento(atend);
    }
    
    @PostMapping("/filas")
    public String processQueues() {
        atendService.processQueues();
        return "As filas foram processadas.";
    }
}