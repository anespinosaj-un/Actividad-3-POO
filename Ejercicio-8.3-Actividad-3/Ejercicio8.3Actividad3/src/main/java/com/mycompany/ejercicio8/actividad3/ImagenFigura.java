/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8.actividad3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Panel que dibuja la imagen de una figura geométrica con sus medidas.
 * Se dibuja con Java2D, así que no necesita archivos de imagen externos.
 *
 * @author Andre
 */
public class ImagenFigura extends JPanel {

    public static final String CILINDRO = "Cilindro";
    public static final String ESFERA = "Esfera";
    public static final String PIRÁMIDE = "Pirámide";
    public static final String CUBO = "Cubo";
    public static final String PRISMA = "Prisma";

    private static final Color RELLENO_CLARO = new Color(200, 225, 255);
    private static final Color RELLENO_OSCURO = new Color(110, 160, 220);
    private static final Color BORDE = new Color(30, 60, 110);
    private static final Color COTA = new Color(200, 40, 40);

    private final String figura;

    public ImagenFigura(String figura) {
        this.figura = figura;
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(180, 180, 200)));
        setToolTipText(figura);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2f));
        g2.setFont(new Font("SansSerif", Font.BOLD, 12));

        // Se dibuja en un lienzo de 200x200 centrado en el panel
        int dx = (getWidth() - 200) / 2;
        int dy = (getHeight() - 200) / 2;
        g2.translate(dx, dy);

        switch (figura) {
            case CILINDRO:
                dibujarCilindro(g2);
                break;
            case ESFERA:
                dibujarEsfera(g2);
                break;
            case PIRÁMIDE:
                dibujarPirámide(g2);
                break;
            case CUBO:
                dibujarCubo(g2);
                break;
            case PRISMA:
                dibujarPrisma(g2);
                break;
            default:
                break;
        }
        g2.dispose();
    }

    private void dibujarCilindro(Graphics2D g2) {
        int x = 50, ancho = 100, arriba = 30, abajo = 160, alto = 30;
        g2.setPaint(new GradientPaint(x, 0, RELLENO_OSCURO, x + ancho, 0, RELLENO_CLARO));
        g2.fillRect(x, arriba + alto / 2, ancho, abajo - arriba);
        g2.fillOval(x, abajo, ancho, alto);
        g2.setColor(RELLENO_CLARO);
        g2.fillOval(x, arriba, ancho, alto);

        g2.setColor(BORDE);
        g2.drawOval(x, arriba, ancho, alto);
        g2.drawLine(x, arriba + alto / 2, x, abajo + alto / 2);
        g2.drawLine(x + ancho, arriba + alto / 2, x + ancho, abajo + alto / 2);
        g2.drawArc(x, abajo, ancho, alto, 180, 180);
        g2.setStroke(punteada());
        g2.drawArc(x, abajo, ancho, alto, 0, 180);

        // Cotas: radio y altura
        g2.setColor(COTA);
        g2.drawLine(x + ancho / 2, arriba + alto / 2, x + ancho, arriba + alto / 2);
        g2.drawString("r", x + ancho * 3 / 4 - 3, arriba + alto / 2 - 3);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(x + ancho + 15, arriba + alto / 2, x + ancho + 15, abajo + alto / 2);
        g2.drawString("h", x + ancho + 20, (arriba + abajo + alto) / 2 + 4);
    }

    private void dibujarEsfera(Graphics2D g2) {
        int x = 30, y = 30, d = 140;
        g2.setPaint(new GradientPaint(x, y, RELLENO_CLARO, x + d, y + d, RELLENO_OSCURO));
        g2.fillOval(x, y, d, d);
        g2.setColor(BORDE);
        g2.drawOval(x, y, d, d);
        // Ecuador
        g2.drawArc(x, y + d / 2 - 15, d, 30, 180, 180);
        g2.setStroke(punteada());
        g2.drawArc(x, y + d / 2 - 15, d, 30, 0, 180);

        // Cota: radio
        g2.setColor(COTA);
        g2.setStroke(new BasicStroke(2f));
        int cx = x + d / 2, cy = y + d / 2;
        g2.fillOval(cx - 3, cy - 3, 6, 6);
        g2.drawLine(cx, cy, x + d, cy);
        g2.drawString("r", cx + d / 4 - 3, cy - 5);
    }

    private void dibujarPirámide(Graphics2D g2) {
        // Base cuadrada en perspectiva y vértice superior
        int[] bx = {30, 120, 170, 80};
        int[] by = {150, 150, 120, 120};
        int vx = 100, vy = 20;

        Polygon caraFrontal = new Polygon(new int[]{bx[0], bx[1], vx}, new int[]{by[0], by[1], vy}, 3);
        Polygon caraLateral = new Polygon(new int[]{bx[1], bx[2], vx}, new int[]{by[1], by[2], vy}, 3);
        g2.setColor(RELLENO_CLARO);
        g2.fill(caraFrontal);
        g2.setColor(RELLENO_OSCURO);
        g2.fill(caraLateral);

        g2.setColor(BORDE);
        g2.draw(caraFrontal);
        g2.draw(caraLateral);
        g2.setStroke(punteada());
        g2.drawLine(bx[2], by[2], bx[3], by[3]);
        g2.drawLine(bx[3], by[3], bx[0], by[0]);
        g2.drawLine(bx[3], by[3], vx, vy);

        // Cotas: altura (centro de la base al vértice), apotema y base
        g2.setColor(COTA);
        int cx = 100, cy = 135;
        g2.drawLine(cx, cy, vx, vy);
        g2.drawString("h", cx + 4, 90);
        g2.setStroke(new BasicStroke(1.5f));
        int mx = (bx[0] + bx[1]) / 2;
        g2.drawLine(mx, by[0], vx, vy);
        g2.drawString("ap", mx - 30, 95);
        g2.drawString("b", mx - 3, by[0] + 18);
    }

    private void dibujarCubo(Graphics2D g2) {
        dibujarCaja(g2, 40, 70, 90, 90, 40);
        g2.setColor(COTA);
        g2.drawString("a", 40 + 45 - 3, 70 + 90 + 18);
    }

    private void dibujarPrisma(Graphics2D g2) {
        int x = 25, y = 85, largo = 110, alto = 70, prof = 45;
        dibujarCaja(g2, x, y, largo, alto, prof);
        g2.setColor(COTA);
        g2.drawString("l", x + largo / 2 - 2, y + alto + 18);
        g2.drawString("w", x + largo + prof / 2 + 6, y + alto - prof / 2 + 10);
        g2.drawString("h", x - 14, y + alto / 2 + 4);
    }

    /**
     * Dibuja una caja (cubo o prisma rectangular) en perspectiva caballera.
     */
    private void dibujarCaja(Graphics2D g2, int x, int y, int largo, int alto, int prof) {
        int d = (int) (prof * 0.7);
        Polygon frente = new Polygon(new int[]{x, x + largo, x + largo, x},
                new int[]{y, y, y + alto, y + alto}, 4);
        Polygon tapa = new Polygon(new int[]{x, x + d, x + largo + d, x + largo},
                new int[]{y, y - d, y - d, y}, 4);
        Polygon lado = new Polygon(new int[]{x + largo, x + largo + d, x + largo + d, x + largo},
                new int[]{y, y - d, y + alto - d, y + alto}, 4);

        g2.setColor(RELLENO_CLARO);
        g2.fill(frente);
        g2.setColor(new Color(225, 238, 255));
        g2.fill(tapa);
        g2.setColor(RELLENO_OSCURO);
        g2.fill(lado);

        g2.setColor(BORDE);
        g2.draw(frente);
        g2.draw(tapa);
        g2.draw(lado);
        // Aristas ocultas
        g2.setStroke(punteada());
        g2.drawLine(x + d, y + alto - d, x + d, y - d);
        g2.drawLine(x + d, y + alto - d, x, y + alto);
        g2.drawLine(x + d, y + alto - d, x + largo + d, y + alto - d);
        g2.setStroke(new BasicStroke(2f));
    }

    private Stroke punteada() {
        return new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, new float[]{5f, 4f}, 0f);
    }
}
