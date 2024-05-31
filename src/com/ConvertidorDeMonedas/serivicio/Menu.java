package com.ConvertidorDeMonedas.serivicio;

import java.util.*;

public class Menu {
    Scanner teclado = new Scanner(System.in);

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
    }

    public String[] obtenerDatos() {

        List<String> opcionesEnCodigoDeMonedas = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD", "MXN");


        String[] valores = {""};
        while (valores.length != 3){
            try {
                System.out.println("Ingresa el indice de la moneda que deseas convertir:");
                int opcion1 = teclado.nextInt() - 1;
                System.out.println("Cual es la cantidad de monedas que deseas convertir?");
                int cantidadDeMonedas = teclado.nextInt();
                System.out.println("Ingresa el indice de la moneda a la que deseas convertir:");
                int opcion2 = teclado.nextInt() - 1;
                System.out.println("*******************************************************");
                // Creacions de un array para almacenar el codigo de las monedas y la cantidad a devorver y retornarlos
                valores = new String[]{opcionesEnCodigoDeMonedas.get(opcion1), String.valueOf(cantidadDeMonedas), opcionesEnCodigoDeMonedas.get(opcion2)};

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Valor no válido: el índice de la moneda está fuera de rango.");
                valores = new String[]{""}; // Reiniciar valores para volver a intentar
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido: por favor ingresa un número.");
                teclado.next(); // Consumir la entrada incorrecta
                valores = new String[]{""}; // Reiniciar valores para volver a intentar
            }
        }
        return valores;
    }

}
