package com.ConvertidorDeMonedas.serivicio;

import com.ConvertidorDeMonedas.modelos.MonedaDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public MonedaDTO consultaExchangerateApi (String monedaBase, String monedaDestino) {
        String APIKEY = "4d256415987b092e7594fa25";
        // Creacion de la URI para hacer la consulta

        URI direccionAPI = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/"
                + monedaBase + "/" + monedaDestino);

        // Creacion del cliente para Solicitudes (HttpClient)
        HttpClient client = HttpClient.newHttpClient();

        // Haciendo la solicitud a la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionAPI)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaDTO.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
