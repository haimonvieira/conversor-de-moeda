package br.com.alura.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {

    private final String yourApiKey;

    public ExchangeRate(String yourApiKey) {
        this.yourApiKey = yourApiKey;
    }


    public void obterConversao(String converterDe, String converterPara, double valor)
            throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/" + yourApiKey + "/latest/" +
                converterDe;
        double taxaDoValor;

        if (validarApi(yourApiKey)){
            System.out.println("validado");
        }else {
            System.out.println("n validado");
        }

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject taxaDeConversao = json.getAsJsonObject("conversion_rates");

            if (taxaDeConversao != null && taxaDeConversao.has(converterPara) && valor > 0) {

                taxaDoValor = taxaDeConversao.get(converterPara).getAsDouble();
                System.out.println("A conversão atual da moeda é: " + taxaDoValor);
                System.out.println(valor + " " + converterDe + " equivale a " + (valor * taxaDoValor) + " " +
                        converterPara);
                System.out.println("1 " + converterDe + " equivale a " + taxaDoValor + " " + converterPara);

            } else if (taxaDeConversao == null) {

                System.out.println("Taxa de conversão inválida");

            } else if (valor <= 0) {

                System.out.println("Valor negativo ou menor e igual a zero");

            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean validarApi(String apiKey) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/BRL";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);


        if(json.has("error-type")){

            if(json.get("error-type").getAsString().equals("invalid-key")){
                return false;
            }

            return false;

        }

        return true;

    }

}
