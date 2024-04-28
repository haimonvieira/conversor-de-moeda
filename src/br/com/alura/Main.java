package br.com.alura;

import br.com.alura.models.ExchangeRate;
import br.com.alura.models.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        String apiKey;

        System.out.println("Insira sua API");
        System.out.printf("> ");
        apiKey = scanner.nextLine();

        ExchangeRate exchangeRate = new ExchangeRate(apiKey);
        boolean validarApi = exchangeRate.validarApi(apiKey);

        while (!validarApi || apiKey.isEmpty()) {

            apiKey = menu.atualizarApi();
            validarApi = menu.validarApiMenu(apiKey);

        }

        System.out.println("API validada com sucesso.");
        System.out.println();

        menu.exibirMenu(apiKey);
        String opcao = menu.escolherOpcao();

        while (opcao.equalsIgnoreCase("n") || opcao.equalsIgnoreCase("não") ||
                opcao.equalsIgnoreCase("nao")) {

            menu.exibirMenu(apiKey);
            opcao = menu.escolherOpcao();

        }


    }


}

