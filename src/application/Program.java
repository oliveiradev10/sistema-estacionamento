package application;

import entities.Estadia;
import entities.FaturaEstacionamento;
import entities.Veiculo;
import enums.CategoriaVeiculo;
import services.ServicoEstacionamento;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("ESTACIONAMENTO");
        System.out.print("Digite sua placa: ");
        String placa = sc.nextLine();
        System.out.print("Qual o modelo do veículo?");
        String modelo = sc.nextLine();
        System.out.print("Qual a categoria do veículo? (CARRO/ MOTO) ");
        String categoria = sc.nextLine();

        Veiculo veiculo = new Veiculo(placa, modelo, CategoriaVeiculo.valueOf(categoria));


        System.out.print("Digite a data de entrada? ");
        String entrada = sc.nextLine();
        LocalDateTime entradaData = LocalDateTime.parse(entrada, fmt);

        System.out.print("Digite a data de saída? ");
        String saida = sc.nextLine();
        LocalDateTime saidaData =  LocalDateTime.parse(saida, fmt);

        Estadia estadia = new Estadia(entradaData, saidaData, veiculo);

        ServicoEstacionamento servicoEstacionamento = new ServicoEstacionamento();
        FaturaEstacionamento fatura = servicoEstacionamento.calcularFatura(estadia);





        System.out.println("Valor base: " +  fatura.getValorBase());
        System.out.println("Taxa: " +  fatura.getTaxa());
        System.out.println("Valor total: " +  fatura.getValorTotal());








        sc.close();
    }
}
