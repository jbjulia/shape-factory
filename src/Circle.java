/**
 * File Name: Circle.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Circle extends the TwoDimensionalShape class and has methods to calculate the area of a circle and display
 * it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (radius), pass the
 * values of these dimensions, and draw the shape.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circle extends TwoDimensionalShape {
    private int radius;

    public Circle() {
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Radius"
        };
    }

    @Override
    public JPanel drawShape() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                FontMetrics metrics = g.getFontMetrics();
                int radiusLabelX = (this.getWidth() - metrics.stringWidth(String.format("Radius: %d", radius))) / 2;
                g.drawString(String.format("Radius: %d", radius), radiusLabelX, 15);
                int diameter = radius * 2;
                int circleX = (this.getWidth() - diameter) / 2;
                int circleY = (this.getHeight() - diameter) / 2;
                g.drawOval(circleX, circleY, diameter, diameter);
                String stats = String.format("This Circle has an area of: %.2f", area());
                int statsLabelX = (this.getWidth() - metrics.stringWidth(stats)) / 2;
                int statsLabelY = circleY + diameter + 30;
                g.drawString(stats, statsLabelX, statsLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.radius = values.get(0);
    }
}