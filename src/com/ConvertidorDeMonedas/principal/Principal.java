package com.ConvertidorDeMonedas.principal;

import com.ConvertidorDeMonedas.modelos.MonedaDTO;
import com.ConvertidorDeMonedas.serivicio.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Moneda> historialDeMonedasConsultadas = new ArrayList<>();

        Menu menuPrincipal = new Menu();
        int eleccionUsuario = menuPrincipal.menu1();
        while (eleccionUsuario!=3) {

            if (eleccionUsuario == 1){
                String condicion = "S";
                while (condicion.equalsIgnoreCase("S")) {

                    // Declaracion de variables
                    Convertidor datosMonedas = new Convertidor();
                    Menu muestraMenu = new Menu();
                    Historial historialDeConsultas = new Historial();

                    // Crear un DateTimeFormatter con el formato deseado
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    // Obtener la fecha y hora actuales
                    LocalDateTime now = LocalDateTime.now();

                    // Formatear la fecha y hora
                    String formattedDateTime = now.format(formatter);

                    muestraMenu.muestraMonedasDisponibles();

                    // Lista con los informacion proparcionada por el usuario donde:
                    // El indice 0 es el codigo de la moneda base
                    // El indice 1 es la cantidad de monedas a converir
                    // El indice 2 es el codigo de moneda destino
                    String[] datos = muestraMenu.obtenerDatos();

                    // Asignacion de valores
                    datosMonedas.setCodigoDeMonedaBase(datos[0]);
                    datosMonedas.setCantidadDeMonedasAConvertir(Integer.valueOf(datos[1]));
                    datosMonedas.setCodigoDeMonedaDestino(datos[2]);
                    datosMonedas.setMomentoDeLaConsulta(formattedDateTime);

                    // Consulta a la API
                    ConsumoApi consultaCambioDeMoneda = new ConsumoApi();
                    MonedaDTO monedaDTO = consultaCambioDeMoneda.consultaExchangerateApi(datosMonedas.getCodigoDeMonedaBase(), datosMonedas.getCodigoDeMonedaDestino());
                    datosMonedas.setTipoDeConvercion(monedaDTO.conversion_rate());

                    // Haciendo la convercion de las monedas
                    datosMonedas.setCantidadConvertida(datosMonedas.convertidor(datosMonedas.getCantidadDeMonedasAConvertir(), datosMonedas.getTipoDeConvercion()));
                    System.out.println(datos[1] + " " + datosMonedas.getCodigoDeMonedaBase() + " son " + datosMonedas.getCantidadConvertida() + " " + datosMonedas.getCodigoDeMonedaDestino());


                    // Preguta al usuario si desea hacer otra convercion o salir del programa
                    condicion = muestraMenu.realizaNuevaConsulta(condicion);

                    historialDeMonedasConsultadas.add(datosMonedas);
                    try {
                        historialDeConsultas.guardarHistorial(historialDeMonedasConsultadas);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (eleccionUsuario == 2) {
                System.out.println("Tu historial de consultas es el siguiente: ");
                historialDeMonedasConsultadas.forEach(System.out::println);
            }
            eleccionUsuario = menuPrincipal.menu1();

        }System.out.println("Vuelva pronto");
    }
}
