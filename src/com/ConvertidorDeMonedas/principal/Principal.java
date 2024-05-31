package com.ConvertidorDeMonedas.principal;

import com.ConvertidorDeMonedas.modelos.MonedaDTO;
import com.ConvertidorDeMonedas.serivicio.ConsumoApi;
import com.ConvertidorDeMonedas.serivicio.Convertidor;
import com.ConvertidorDeMonedas.serivicio.Menu;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String condicion = "S";
        while (condicion.equals("S")) {

                Scanner decicion = new Scanner(System.in);
                // Declaracion de variables
                Convertidor datosMonedas = new Convertidor();
                Menu muestraMenu = new Menu();
                muestraMenu.muestraMonedasDisponibles();
                // Lista con los informacion proparcionada por el usuario donde
                // El indice 0 es el codigo de la moneda base
                // El indice 1 es la cantidad de monedas a converir
                // El indice 2 es el codigo de moneda destino
                String[] datos = muestraMenu.obtenerDatos();

                // Asignacion de valores
                datosMonedas.setCodigoDeMonedaBase(datos[0]);
                datosMonedas.setCantidadDeMonedasAConvertir(Integer.valueOf(datos[1]));
                datosMonedas.setCodigoDeMonedaDestino(datos[2]);

                // Consulta de la API
                ConsumoApi consultaCambioDeMoneda = new ConsumoApi();
                MonedaDTO monedaDTO = consultaCambioDeMoneda.cambio(datosMonedas.getCodigoDeMonedaBase(), datosMonedas.getCodigoDeMonedaDestino());
                datosMonedas.setTipoDeConvercion(monedaDTO.conversion_rate());

                //
                double cantidadDeMonedas = datosMonedas.convertidor(datosMonedas.getCantidadDeMonedasAConvertir(), datosMonedas.getTipoDeConvercion());

                System.out.println(datos[1] + " " + datosMonedas.getCodigoDeMonedaBase() + " son " + cantidadDeMonedas + " " + datosMonedas.getCodigoDeMonedaDestino() );

            // Solicitar al usuario si desea realizar otra consulta
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("Deseas hacer otra consulta? (S/N)");
                condicion = decicion.nextLine().toUpperCase();
                if (condicion.equals("S") || condicion.equals("N")) {
                    entradaValida = true;
                } else {
                    System.out.println("Entrada no válida. Por favor, ingresa 'S' para sí o 'N' para no.");
                }
            }

        }
        System.out.println("Vuelva pronto");
    }
}
