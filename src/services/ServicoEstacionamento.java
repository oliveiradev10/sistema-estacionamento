package services;

import entities.Estadia;
import entities.FaturaEstacionamento;
import entities.Veiculo;
import enums.CategoriaVeiculo;


import java.time.Duration;

import static enums.CategoriaVeiculo.CARRO;


public class ServicoEstacionamento {

    private long tempoHoras(Estadia estadia) {


        Duration duration = Duration.between(estadia.getEntrada(), estadia.getSaida());
        long horas = duration.toHours();
        return horas;

    }

    private double valorHora(Veiculo veiculo) {
        if (veiculo.getCategoria() == CategoriaVeiculo.CARRO) {

            return 10.0;

        } else {
            return 5.0;

        }
    }

    public FaturaEstacionamento calcularFatura(Estadia estadia){
        Veiculo veiculo = estadia.getVeiculo();
        long horas = tempoHoras(estadia);

        double precoPorHora = valorHora(veiculo);
        double valorBase = horas * precoPorHora;
        double taxa = 10.0;

        double total = valorBase + taxa;

        return new FaturaEstacionamento(valorBase, taxa, total);

    }



}
