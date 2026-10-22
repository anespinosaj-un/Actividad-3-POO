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
 * Ventana para calcular el volumen y la superficie de un prisma rectangular.
 *
 * @author Andre
 */
public class VentanaPrisma extends JFrame {

    private JLabel largo;
    private JLabel ancho;
    private JLabel altura;
    private JTextField campoLargo;
    private JTextField campoAncho;
    private JTextField campoAltura;
    private JButton calcular;
    private JLabel volumen;
    private JLabel superficie;

    public VentanaPrisma() {
        initComponents();
    }

    private void initComponents() {
        largo = new JLabel("Largo (cm):");
        ancho = new JLabel("Ancho (cm):");
        altura = new JLabel("Altura (cm):");
        campoLargo = new JTextField(8);
        campoAncho = new JTextField(8);
        campoAltura = new JTextField(8);
        calcular = new JButton("Calcular");
        volumen = new JLabel("Volumen (cm3):");
        superficie = new JLabel("Superficie (cm2):");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Prisma rectangular");

        calcular.addActionListener(evt -> calcularActionPerformed());

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(9, 5, 9, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; formulario.add(largo, c);
        c.gridx = 1; formulario.add(campoLargo, c);
        c.gridx = 0; c.gridy = 1; formulario.add(ancho, c);
        c.gridx = 1; formulario.add(campoAncho, c);
        c.gridx = 0; c.gridy = 2; formulario.add(altura, c);
        c.gridx = 1; formulario.add(campoAltura, c);
        c.gridx = 1; c.gridy = 3; formulario.add(calcular, c);
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2; formulario.add(volumen, c);
        c.gridy = 5; formulario.add(superficie, c);

        JPanel contenedor = new JPanel(new BorderLayout(15, 0));
        contenedor.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 15));
        contenedor.add(formulario, BorderLayout.CENTER);
        contenedor.add(new ImagenFigura(ImagenFigura.PRISMA), BorderLayout.EAST);
        setContentPane(contenedor);

        pack();
        setLocationRelativeTo(null);
    }

    private void calcularActionPerformed() {
        boolean error = false;
        try {
            double l = Double.parseDouble(campoLargo.getText());
            double w = Double.parseDouble(campoAncho.getText());
            double h = Double.parseDouble(campoAltura.getText());
            Prisma prisma = new Prisma(l, w, h);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaPrisma().setVisible(true));
    }
}
