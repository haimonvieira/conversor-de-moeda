package br.com.alura;

import br.com.alura.models.ExchangeRate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Insira a moeda
                                
                USD - Dolar Americano     EUR - Euro
                BRL - Real Brasileiro     CAD - Dolar Canadense
                GBP - Libra Esterlina     JPY - Iene Japonês
                """);

        System.out.println("Insira a moeda que deseja converter (De)");
        System.out.printf("> ");
        String moedaDe = scanner.nextLine().toUpperCase();

        System.out.println("Para qual moeda (Para)");
        System.out.printf("> ");
        String moedaPara = scanner.nextLine().toUpperCase();

        System.out.println("Insira o valor em " + moedaDe);
        System.out.printf("> ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.obterConversao(moedaDe, moedaPara, valor);

        System.out.println("Deseja sair? (S/N)");
        System.out.printf("> ");
        String opcao = scanner.nextLine();


        while (opcao.equalsIgnoreCase("n") || opcao.equalsIgnoreCase("não") ||
        opcao.equalsIgnoreCase("nao")) {

            System.out.println("""
                    Insira a moeda
                                    
                    USD - Dolar Americano     EUR - Euro
                    BRL - Real Brasileiro     CAD - Dolar Canadense
                    GBP - Libra Esterlina     JPY - Iene Japonês
                    """);

            System.out.println("Insira a moeda que deseja converter (De)");
            System.out.printf("> ");
            moedaDe = scanner.nextLine().toUpperCase();

            System.out.println("Para qual moeda (Para)");
            System.out.printf("> ");
            moedaPara = scanner.nextLine().toUpperCase();

            System.out.println("Insira o valor");
            System.out.printf("> ");
            valor = scanner.nextDouble();
            scanner.nextLine();

            exchangeRate.obterConversao(moedaDe, moedaPara, valor);

            System.out.println("/nDeseja sair? (S/N)");
            System.out.printf("> ");
            opcao = scanner.nextLine();

        }

    }


}
