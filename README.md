Parking Management System

Projeto desenvolvido em Java para gerenciamento de estacionamento e cálculo de faturamento de veículos.

Funcionalidades
Cadastro de veículo
Placa
Modelo
Categoria (CARRO ou MOTO)
Registro de entrada e saída utilizando LocalDateTime.
Cálculo automático do valor da estadia:
Carro: R$ 10,00 por hora
Moto: R$ 5,00 por hora
Taxa fixa: R$ 10,00
Geração de fatura com:
Valor base
Taxa
Valor total
Validações implementadas
Validação de formato de data utilizando DateTimeParseException.
Validação de categoria do veículo utilizando IllegalArgumentException.
Impede que a data de saída seja anterior à data de entrada.
Tecnologias utilizadas
Java 17
Programação Orientada a Objetos (POO)
Enum
LocalDateTime
Duration
Tratamento de Exceções
Conceitos praticados
Classes e Objetos
Encapsulamento
Serviços
Entidades
Enumerações
Métodos
Regras de negócio
Tratamento de exceções
Manipulação de datas e horas
Autor

Ítalo Oliveira
