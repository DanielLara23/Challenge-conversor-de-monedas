package com.ConvertidorDeMonedas.serivicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Historial {
    public void guardarHistorial(List listaDatosMoneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("Historial de consultas.json");
        escritura.write(gson.toJson(listaDatosMoneda));
        escritura.close();
    }
}
