# api-pagamentos
API de pagamentos, desenvolvida para o desafio técnico ToolsJava Challenge

# Objetivo
Meu desafio nesse projeto era Implementar uma API de pagamento contendo as seguintes operações 
Pagamento , Etorno e Consulta 

# Tecnologias Utilizadas 

- Java 17- Versão do Java
- Spring-boot (v3.0.6) - Framework para desenvolvimento de aplicações web
- Maven (Apache Maven v4.0.0) - Ferramenta de gerenciamento de build
- H2 - Banco de dados em memória.
- IntelliJ - IDE utilizada no desenvolvimento.

#Testando API de Pagamento 

Para testar a API foi utilizado o insomnia com as seguintes operações

Solicitação de pagamento
``` POST http://localhost:8080/pagamentos ```

```
{
	 "cartao": "4444********1234",
	"descricao": {
		"valor": "200.50",
		"dataHora": "01/05/2021 18:30:00",
		"estabelecimento": "PetShop Mundo cão"
	},
	"formaPagamento": {
		"tipo": "AVISTA",
		"parcelas": "1"
	}
}
```

Resposta da solicitação de Pagamento 

```
{
	"id": "4b0917f0-2fe7-42b1-bcda-fe52ba00797f",
	"cartao": "4444********1234",
	"descricao": {
		"valor": "200.50",
		"dataHora": "01/05/2021 18:30:00",
		"estabelecimento": "PetShop Mundo cão",
		"nsu": "61c9ea88-6a8f-476d-be7b-39d93dff60e2",
		"codigoAutorizacao": "35eacd0d-acf0-436a-b1c9-376cf9a6b9aa",
		"status": "AUTORIZADO"
	},
	"formaPagamento": {
		"tipo": "AVISTA",
		"parcelas": "1"
	}
}
```

Etorno de pagamento ``` PUT http://localhost:8080/pagamentos/{id} ```

```
{
	"id": "4b0917f0-2fe7-42b1-bcda-fe52ba00797f",
	"cartao": "4444********1234",
	"descricao": {
		"valor": "200.50",
		"dataHora": "01/05/2021 18:30:00",
		"estabelecimento": "PetShop Mundo cão",
		"nsu": "61c9ea88-6a8f-476d-be7b-39d93dff60e2",
		"codigoAutorizacao": "35eacd0d-acf0-436a-b1c9-376cf9a6b9aa",
		"status": "NEGADO"
	},
	"formaPagamento": {
		"tipo": "AVISTA",
		"parcelas": "1"
	}
}
```

Busca de todas as Transações ``` GET http://localhost:8080/pagamentos ```

```
[
	{
		"id": "677dc488-0b5d-4a49-bc13-36c43e8ef2c9",
		"cartao": "4444********1234",
		"descricao": {
			"valor": "200.50",
			"dataHora": "01/05/2021 18:30:00",
			"estabelecimento": "PetShop Mundo cão",
			"nsu": "3b1d9666-9996-40f6-9fd6-e67f3227a4f0",
			"codigoAutorizacao": "c0a7a209-98b7-4f68-8bd0-600c7bdf4a7f",
			"status": "AUTORIZADO"
		},
		"formaPagamento": {
			"tipo": "AVISTA",
			"parcelas": "1"
		}
	},
	{
		"id": "4b0917f0-2fe7-42b1-bcda-fe52ba00797f",
		"cartao": "4444********1234",
		"descricao": {
			"valor": "200.50",
			"dataHora": "01/05/2021 18:30:00",
			"estabelecimento": "PetShop Mundo cão",
			"nsu": "61c9ea88-6a8f-476d-be7b-39d93dff60e2",
			"codigoAutorizacao": "35eacd0d-acf0-436a-b1c9-376cf9a6b9aa",
			"status": "NEGADO"
		},
		"formaPagamento": {
			"tipo": "AVISTA",
			"parcelas": "1"
		}
	}
]
```

Busca de apenas uma Transação ``` GET http://localhost:8080/pagamentos/{id} ```

```
{
	"id": "677dc488-0b5d-4a49-bc13-36c43e8ef2c9",
	"cartao": "4444********1234",
	"descricao": {
		"valor": "200.50",
		"dataHora": "01/05/2021 18:30:00",
		"estabelecimento": "PetShop Mundo cão",
		"nsu": "3b1d9666-9996-40f6-9fd6-e67f3227a4f0",
		"codigoAutorizacao": "c0a7a209-98b7-4f68-8bd0-600c7bdf4a7f",
		"status": "AUTORIZADO"
	},
	"formaPagamento": {
		"tipo": "AVISTA",
		"parcelas": "1"
	}
}
```