package br.com.alura.models;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void exibirMenu(String apiKey) throws IOException, InterruptedException {
        ExchangeRate exchangeRate = new ExchangeRate(apiKey);

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

        exchangeRate.obterConversao(moedaDe, moedaPara, valor);


    }

    public String escolherOpcao(){

        System.out.println("Deseja sair? (S/N)");
        System.out.printf("> ");
        String opcao = scanner.nextLine();

        return opcao;

    }

    public boolean validarApiMenu(String apiKey) throws IOException, InterruptedException {

        ExchangeRate exchangeRate = new ExchangeRate(apiKey);
        boolean validarApi = exchangeRate.validarApi(apiKey);

        return validarApi;

    }

    public String atualizarApi() throws IOException, InterruptedException {

        String apiKey = "";
        boolean apiKeyVerificar = false;

        while (!apiKeyVerificar){

            System.out.println("Chave de API inválida");
            System.out.println("Insira novamente");
            System.out.printf("> ");
            apiKey = scanner.nextLine();
            apiKeyVerificar = validarApiMenu(apiKey);

            if (apiKeyVerificar){
                System.out.printf("Sem erros relacionado a API.");
                System.out.println();
            }

        }

        return apiKey;

    }




}
