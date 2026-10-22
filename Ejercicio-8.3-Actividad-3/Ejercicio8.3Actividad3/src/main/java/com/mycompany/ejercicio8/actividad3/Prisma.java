/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

/**
 * Prisma rectangular (ortoedro): base rectangular de largo x ancho y una altura.
 *
 * @author Andre
 */
public class Prisma extends FiguraGeométrica {

    private double largo;
    private double ancho;
    private double altura;

    public double calcularVolumen() {
        double volumen = largo * ancho * altura;
        return volumen;
    }

    public double calcularSuperficie() {
        double áreaBases = 2.0 * largo * ancho;
        double áreaLados = 2.0 * (largo + ancho) * altura;
        return áreaBases + áreaLados;
    }

    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

}
