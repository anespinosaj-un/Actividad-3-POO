/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para calcular el volumen y la superficie de un cubo.
 *
 * @author Andre
 */
public class VentanaCubo extends JFrame {

    private JLabel arista;
    private JTextField campoArista;
    private JButton calcular;
    private JLabel volumen;
    private JLabel superficie;

    public VentanaCubo() {
        initComponents();
    }

    private void initComponents() {
        arista = new JLabel("Arista (cm):");
        campoArista = new JTextField(8);
        calcular = new JButton("Calcular");
        volumen = new JLabel("Volumen (cm3):");
        superficie = new JLabel("Superficie (cm2):");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Cubo");

        calcular.addActionListener(evt -> calcularActionPerformed());

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(9, 5, 9, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; formulario.add(arista, c);
        c.gridx = 1; formulario.add(campoArista, c);
        c.gridx = 1; c.gridy = 1; formulario.add(calcular, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; formulario.add(volumen, c);
        c.gridy = 3; formulario.add(superficie, c);

        JPanel contenedor = new JPanel(new BorderLayout(15, 0));
        contenedor.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 15));
        contenedor.add(formulario, BorderLayout.CENTER);
        contenedor.add(new ImagenFigura(ImagenFigura.CUBO), BorderLayout.EAST);
        setContentPane(contenedor);

        pack();
        setLocationRelativeTo(null);
    }

    private void calcularActionPerformed() {
        boolean error = false;
        try {
            double a = Double.parseDouble(campoArista.getText());
            Cubo cubo = new Cubo(a);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaCubo().setVisible(true));
    }
}
