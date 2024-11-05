Teste para UBOTS de atendimento.

**Endpoints e Json para testes**

POST: https:localhost:8080/api/distribuir 

Envio para o agente de cartões.

{
    
    "assunto": "Problemas com cartão",
    "descricao": "Meu cartão está bloqueado"

}

Envio para o agente de empréstimos.

{
    
    "assunto": "Contratação de empréstimo",
    "descricao": "Gostaria de contratar um empréstimo"

}

Envio para o agente de outros.

{
    
    "assunto": "Mudança de endereço",
    "descricao": "Preciso atualizar meu endereço"

}

Obs.: Caso queira processar as filas segue endpoint, mas foi determinado para cada agente 30 segundos de atendimento, dentro desse tempo o agente estará ocupado,
quando terminar, será processado e via console irá informa-lo que o agente estará disponivel.

POST: http://localhost:8080/api/filas
