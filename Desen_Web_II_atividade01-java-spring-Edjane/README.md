# API REST - Sistema de Entregas

Projeto desenvolvido em Java com Spring Boot para a atividade da disciplina Desenvolvimento Web II.

## Requisitos 

- Entidade `Entrega`
- DTO de entrada e saída
- Enum para categoria
- Validação com `@Valid`, `@NotBlank`, `@NotNull`, `@Min`
- Interface de serviço
- Duas implementações de serviço
- Uso de `@Autowired` e `@Qualifier`
- CRUD completo com `ResponseEntity`
- Exceção customizada
- Persistência em memória
- Busca customizada por categoria

## Domínio escolhido

Sistema de Entregas, no qual o valor recebido depende da quantidade de caixas e do tipo de serviço escolhido.

## Regras de negócio

### Implementação simples (`impl=simples`)
- Aceita apenas categoria `SIMPLES`
- Se quantidade de caixas > 10, valor = 100.0
- Caso contrário, valor = 50.0

### Implementação expressa (`impl=expressa`)
- Aceita apenas categoria `EXPRESSA`
- Se quantidade de caixas > 10, valor = 180.0
- Caso contrário, valor = 120.0

## Como executar

### Pré-requisitos
- Maven
- Postman instalado (Ou versão web)

### Executar
```bash
mvn spring-boot:run
```

A API ficará disponível em:
```bash
http://localhost:8080
```

## Endpoints

### Status
- `GET /entregas/status`

### Criar entrega
- `POST /entregas?impl=simples`
- `POST /entregas?impl=expressa`

Exemplo body:
```json
{
  "cliente": "Edjane",
  "quantidadeCaixas": 12,
  "categoria": "SIMPLES"
}
```

### Listar
- `GET /entregas?impl=simples`
- `GET /entregas?impl=expressa`

### Buscar por id
- `GET /entregas/1?impl=simples`

### Atualizar
- `PUT /entregas/1?impl=expressa`

### Remover
- `DELETE /entregas/1?impl=simples`

### Buscar por categoria
- `GET /entregas/categoria/SIMPLES?impl=simples`

## Arquivos de entrega
Na pasta `entrega/` estão:
- Collection do Postman
- Justificativa do domínio
## Interface
Para facilitar a visualização da entidade funcionando, foi criada em .HTML algo simples, apenas para que o usuário consiga compreender o que está acontecendo
## Pasta imagens
Na pasta imagens estão os prints da API funcionando, bem como, roteamentos no Postman
