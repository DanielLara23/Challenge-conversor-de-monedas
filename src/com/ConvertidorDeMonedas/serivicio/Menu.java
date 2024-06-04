package com.ConvertidorDeMonedas.serivicio;
import java.util.Scanner;

import java.util.*;

public class Menu {
    Scanner teclado = new Scanner(System.in);
    public int menu1 (){
        System.out.println("""
                Que deseas hacer?
                Preciona 1 para realizar una consulta
                Preciona 2 para ver tu historial de consultas
                Preciona 3 para salir""");
                return teclado.nextInt();
    }

    public void muestraMonedasDisponibles(){
        List<String> nombreDeMonedas = Arrays.asList("Peso argentino", "Boliviano boliviano", "Real brasileño", "Peso chileno", "Peso colombiano", "Dólar estadounidense", "Peso mexicano");
        System.out.println("""
                *******************************************************
                Bienvenido al conversor de monedas.
                Estas son las monedas disponibles:""");
        final int[] index = {1};
        nombreDeMonedas.forEach(elemento -> {
            System.out.println(index[0] + "._ " + elemento);
            index[0]++;
        });
        System.out.println("Para ver tu historial preciona H");
    }

        public String[] obtenerDatos() {

            List<String> listaCodigosDeMonedas = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD", "MXN");
            String[] valores = {""};

            while (valores.length != 3){
                int moneda1;
                int cantidadDeMonedas;
                int moneda2;


                // Entrada y validacion de la moneda base
                try {
                    System.out.println("Ingresa el índice de la moneda que deseas convertir:");
                    moneda1 = teclado.nextInt() - 1;
                    if (moneda1 < 0 || moneda1 >= listaCodigosDeMonedas.size()) {
                        throw new ArrayIndexOutOfBoundsException("Valor no válido: el índice de la moneda está fuera de rango.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    continue; // Volver al inicio del bucle
                } catch (InputMismatchException e) {
                    System.out.println("Valor no válido: por favor ingresa un número.");
                    teclado.next(); // Consumir la entrada incorrecta
                    continue; // Volver al inicio del bucle
                }

                // Entrada y validacion de la cantidad de monedas a convertir
                try {
                    System.out.println("Cual es la cantidad de monedas que deseas convertir?");
                    cantidadDeMonedas = teclado.nextInt();
                    if (cantidadDeMonedas <= 0) {
                        throw new IllegalArgumentException("Valor no válido: la cantidad debe ser mayor que cero.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue; // Volver al inicio del bucle
                } catch (InputMismatchException e) {
                    System.out.println("Valor no válido: por favor ingresa un número.");
                    teclado.next(); // Consumir la entrada incorrecta
                    continue; // Volver al inicio del bucle
                }

                // Entrada y validacion de la moneda de destino
                try {
                    System.out.println("Ingresa el índice de la moneda a la que deseas convertir:");
                    moneda2 = teclado.nextInt() - 1;
                    if (moneda2 < 0 || moneda2 >= listaCodigosDeMonedas.size()) {
                        throw new ArrayIndexOutOfBoundsException("Valor no válido: el índice de la moneda está fuera de rango.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    continue; // Volver al inicio del bucle
                } catch (InputMismatchException e) {
                    System.out.println("Valor no válido: por favor ingresa un número.");
                    teclado.next(); // Consumir la entrada incorrecta para no generar un bucle infinita
                    continue; // Volver al inicio del bucle
                }

                System.out.println("*******************************************************");
                // Creación de un array para almacenar el código de las monedas y la cantidad a devolver y retornarlos
                valores = new String[]{listaCodigosDeMonedas.get(moneda1), String.valueOf(cantidadDeMonedas), listaCodigosDeMonedas.get(moneda2)};
            }
            return valores;
        }

    public String realizaNuevaConsulta (String condicion){
        Scanner decicion = new Scanner(System.in);

        // Solicitar al usuario si desea realizar otra consulta
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Deseas hacer otra consulta? (S/N)");
            condicion = decicion.nextLine();
            if (condicion.equalsIgnoreCase("S") || condicion.equalsIgnoreCase("N")) {
                entradaValida = true;
            } else {
                System.out.println("Entrada no válida. Por favor, ingresa 'S' para sí o 'N' para no.");
            }
        }
        return condicion;
    }
}
