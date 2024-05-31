package com.ConvertidorDeMonedas.serivicio;

public class Moneda {
    private String codigoDeMonedaBase;
    private String codigoDeMonedaDestino;
    private int cantidadDeMonedasAConvertir;

    public int getCantidadDeMonedasAConvertir() {
        return cantidadDeMonedasAConvertir;
    }

    public void setCantidadDeMonedasAConvertir(int cantidadDeMonedasAConvertir) {
        this.cantidadDeMonedasAConvertir = cantidadDeMonedasAConvertir;
    }

    public String getCodigoDeMonedaBase() {
        return codigoDeMonedaBase;
    }

    public void setCodigoDeMonedaBase(String codigoDeMonedaBase) {
        this.codigoDeMonedaBase = codigoDeMonedaBase;
    }

    public String getCodigoDeMonedaDestino() {
        return codigoDeMonedaDestino;
    }

    public void setCodigoDeMonedaDestino(String codigoDeMonedaDestino) {
        this.codigoDeMonedaDestino = codigoDeMonedaDestino;
    }
}
