/**
 * File Name: Triangle.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Triangle extends the TwoDimensionalShape class and has methods to calculate the area of a triangle and
 * display it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (base, height),
 * pass the values of these dimensions, and draw the shape.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Triangle extends TwoDimensionalShape {
    private int base, height;

    public Triangle() {
    }

    @Override
    public double area() {
        return (base * height) / 2.0d;
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Base",
                "Height"
        };
    }

    @Override
    public JPanel drawShape() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String label = String.format("Base: %d, Height: %d", base, height);
                FontMetrics metrics = g.getFontMetrics();
                int labelX = (this.getWidth() - metrics.stringWidth(label)) / 2;
                g.drawString(label, labelX, 15);
                String stats = String.format("This Triangle has an area of: %.2f", area());
                int stringX = (this.getWidth() - metrics.stringWidth(stats)) / 2;
                int stringY = (this.getHeight() + height) / 2 + 30;
                int triX1 = (this.getWidth() / 2) - base;
                int triX2 = this.getWidth() / 2;
                int triX3 = (this.getWidth() / 2) + base;
                int triY1 = (this.getHeight() - height) / 2;
                int triY2 = (this.getHeight() + height) / 2;
                int[] x = {
                        triX1,
                        triX2,
                        triX3
                };
                int[] y = {
                        triY2,
                        triY1,
                        triY2
                };
                g.drawString(stats, stringX, stringY);
                g.drawPolygon(x, y, 3);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.base = values.get(0);
        this.height = values.get(1);
    }
}