/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

/**
 * Cubo: figura con seis caras cuadradas iguales.
 *
 * @author Andre
 */
public class Cubo extends FiguraGeométrica {

    private double arista;

    public double calcularVolumen() {
        double volumen = Math.pow(arista, 3.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 6.0 * Math.pow(arista, 2.0);
        return superficie;
    }

    public Cubo(double arista) {
        this.arista = arista;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

}
