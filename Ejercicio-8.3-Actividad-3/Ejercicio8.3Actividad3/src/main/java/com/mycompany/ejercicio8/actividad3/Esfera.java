/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

/**
 *
 * @author Andre
 */
public class Esfera extends FiguraGeométrica{
    
    private double radio;
    
    public double calcularVolumen() {
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(this.radio, 3.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 4.0 * Math.PI * Math.pow(this.radio, 2.0);
        return superficie;
    }
    
    public Esfera(double radio) {
        this.radio = radio;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }
    
}
