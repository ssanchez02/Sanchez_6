/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContextoProblema;

/**
 *
 * @author Sebastián Sanchez
 */
public class Celular {
    private String modelo;
    private Double pantalla;

    public Celular(String modelo, Double pantalla) {
        this.modelo = modelo;
        this.pantalla = pantalla;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPantalla() {
        return pantalla;
    }

    public void setPantalla(Double pantalla) {
        this.pantalla = pantalla;
    }
    @Override
    public String toString() {
        return "Modelo = " + modelo + "\nTamaño pantalla = " + pantalla + " pulgadas";
    }
}
