/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

/**
 *
 * @author Andre
 */

public class Notas {
    double[] listaNotas;

    public Notas() {
        listaNotas = new double[5]; // Crea un array de 5 notas
    }

    double calcularPromedio() {
        double suma = 0;
        // CORRECCIÓN: Empezamos en i=0 para sumar todas las notas
        for(int i=0; i < listaNotas.length; i++) { 
            suma = suma + listaNotas[i]; 
        }
        return (suma / listaNotas.length);
    }

    double calcularDesviación() {
        double prom = calcularPromedio(); /* Invoca el método para calcular el promedio */ // CORRECCIÓN: Cerrado correctamente
        double suma = 0;
        for(int i=0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - prom, 2 );
        }
        return Math.sqrt (suma/listaNotas.length ); /* Retorna el cálculo final de la desviación */
    }

    double calcularMenor() {
        double menor = listaNotas[0]; /* Define una variable como la nota menor */ // CORRECCIÓN: Cerrado correctamente
        for(int i=0; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        return menor;
    }

    double calcularMayor() {
        double mayor = listaNotas[0]; /* Define una variable como la nota mayor */
        for(int i=0; i < listaNotas.length; i++) { 
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }
}