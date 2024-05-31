package com.ConvertidorDeMonedas.serivicio;

import com.ConvertidorDeMonedas.modelos.MonedaDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public MonedaDTO cambio (String monedaBase, String monedaDestino) {

        // Creacion de la URI para hacer la consulta

        URI direccionAPI = URI.create("https://v6.exchangerate-api.com/v6/4d256415987b092e7594fa25/pair/"
                +monedaBase +"/"+monedaDestino);

        // Creacion de el cliente para Solicitudes (HttpClient)
        HttpClient client = HttpClient.newHttpClient();

        // Hacendo la solicitud
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
