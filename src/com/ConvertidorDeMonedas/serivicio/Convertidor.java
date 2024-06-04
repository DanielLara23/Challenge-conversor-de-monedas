package com.ConvertidorDeMonedas.serivicio;

public class Convertidor extends com.ConvertidorDeMonedas.serivicio.Moneda {
    private double tipoDeConvercion;

    public String getMomentoDeLaConsulta() {
        return momentoDeLaConsulta;
    }

    public void setMomentoDeLaConsulta(String momentoDeLaConsulta) {
        this.momentoDeLaConsulta = momentoDeLaConsulta;
    }

    private String momentoDeLaConsulta;
    private int cantidadDeMonedasAConvertir;
    private double cantidadConvertida;


    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    public int getCantidadDeMonedasAConvertir() {
        return cantidadDeMonedasAConvertir;
    }

    public void setCantidadDeMonedasAConvertir(int cantidadDeMonedasAConvertir) {
        this.cantidadDeMonedasAConvertir = cantidadDeMonedasAConvertir;
    }

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
    @Override
    public String toString() {
        int contador = 0;
        return
                "- El momento de la consulta fue: '" + getMomentoDeLaConsulta()+

                ", Codigo de la moneda base: '" + getCodigoDeMonedaBase() +

                ", Cantidad de monedas a convertir: " + getCantidadDeMonedasAConvertir() +

                ", Codigo de la moneda de destino: '" + getCodigoDeMonedaDestino() +

                ", Tipo de cambio: " + tipoDeConvercion +

                ", Cantidad de monedas convertidas: " + getCantidadConvertida();
    }
}