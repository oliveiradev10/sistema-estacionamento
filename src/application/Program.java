package application;

import entities.Estadia;
import entities.FaturaEstacionamento;
import entities.Veiculo;
import enums.CategoriaVeiculo;
import services.ServicoEstacionamento;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        System.out.print("Qual o modelo do veículo ? ");
        String modelo = sc.nextLine();

        CategoriaVeiculo categoriaVeiculo = null;
       Veiculo veiculo = null;
        while (categoriaVeiculo == null) {

            System.out.print("Qual a categoria do veículo ? (CARRO/ MOTO) ");
            String categoria = sc.nextLine();

            try {

                categoriaVeiculo = CategoriaVeiculo.valueOf(categoria);
                veiculo = new Veiculo(placa, modelo, categoriaVeiculo);


            } catch (IllegalArgumentException i) {

                System.out.println("DIGITE CARRO OU MOTO, COM TODAS AS LETRAS MAÍUSCULAS ! ");
            }
        }


        LocalDateTime entradaData = null;
        while (entradaData == null) {

            System.out.print("Digite a data de entrada: ");
            String entrada = sc.nextLine();

            try {
                entradaData = LocalDateTime.parse(entrada, fmt);
            } catch (DateTimeParseException e) {
                System.out.println("ERRO ! Digite o formato  correto (dd/MM/yyyy HH:mm)  ");
            }
        }

        LocalDateTime saidaData = null;
        while (saidaData == null) {
            System.out.print("Digite a data de saída? ");
            String saida = sc.nextLine();

            try {

                saidaData = LocalDateTime.parse(saida, fmt);

                if (saidaData.isBefore(entradaData)){
                    System.out.println("A data de saída deve ser posterior à data de entrada.");
                    saidaData = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("ERRO ! Digite o formato  correto (dd/MM/yyyy HH:mm)");
            }
        }
        Estadia estadia = new Estadia(entradaData, saidaData, veiculo);

        ServicoEstacionamento servicoEstacionamento = new ServicoEstacionamento();
        FaturaEstacionamento fatura = servicoEstacionamento.calcularFatura(estadia);


        System.out.println("===== FATURA =====");
        System.out.println();
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Categoria: " + categoriaVeiculo);
        System.out.println();
        System.out.println("Entrada: " + entradaData.format(fmt));
        System.out.println("Saída: " + saidaData.format(fmt));
        System.out.println();

        System.out.printf("Valor base: %.2f%n" , fatura.getValorBase());
        System.out.printf("Taxa: %.2f%n" , fatura.getTaxa());
        System.out.println();
        System.out.printf("TOTAL: : %.2f%n" , fatura.getValorTotal());


        sc.close();
    }
}
