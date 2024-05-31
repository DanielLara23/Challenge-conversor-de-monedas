package com.ConvertidorDeMonedas.serivicio;

public class Convertidor extends com.ConvertidorDeMonedas.serivicio.Moneda {
    private double tipoDeConvercion;
    com.ConvertidorDeMonedas.serivicio.Moneda moneda = new com.ConvertidorDeMonedas.serivicio.Moneda();

    public double getTipoDeConvercion() {
        return tipoDeConvercion;
    }

    public void setTipoDeConvercion(double tipoDeConvercion) {
        this.tipoDeConvercion = tipoDeConvercion;
    }

    public double convertidor (int cantidad, double valor){
        double nuevaCantidad = Double.valueOf(cantidad) * valor;
        return nuevaCantidad;
    }
}