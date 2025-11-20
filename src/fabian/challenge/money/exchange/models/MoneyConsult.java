package fabian.challenge.money.exchange.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MoneyConsult {
    //Variables

    String moneyCountry1;
    String moneyCountry2;

    //Method to consult exchange country money and consul into api

    public Money chooseExchange(int exchangeType) {
        //Choose money to exchange:

        switch (exchangeType) {
            case 1:
                moneyCountry1 = "USD";
                moneyCountry2 = "COP";
                break;
            case 2:
                moneyCountry1 = "COP";
                moneyCountry2 = "USD";
                break;
            case 3:
                moneyCountry1 = "USD";
                moneyCountry2 = "EUR";
                break;
            case 4:
                moneyCountry1 = "EUR";
                moneyCountry2 = "USD";
                break;
            case 5:
                moneyCountry1 = "USD";
                moneyCountry2 = "GBP";
                break;
            case 6:
                moneyCountry1 = "GBP";
                moneyCountry2 = "USD";
                break;
            default:
                System.out.println(moneyCountry1 + " " + moneyCountry2);
        };

        //APIRest consult:

        URI url = URI.create("https://v6.exchangerate-api.com/v6/1ea9cb64569fd475fd9dee73/pair/" + moneyCountry1 + "/" + moneyCountry2);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Gson Object respond:
            return new Gson().fromJson(response.body(), Money.class);
        } catch (Exception e) {
            throw new RuntimeException("Money no found.");
        }
    }
}
