/**
 * File Name: Rectangle.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Rectangle extends the TwoDimensionalShape class and has methods to calculate the area of a rectangle and
 * display it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (width, height),
 * pass the values of these dimensions, and draw the shape.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends TwoDimensionalShape {
    private int width, height;

    public Rectangle() {
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Width",
                "Height"
        };
    }

    @Override
    public JPanel drawShape() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String dimensions = String.format("Width: %d, Height: %d", width, height);
                FontMetrics metrics = g.getFontMetrics();
                int dimensionsX = (this.getWidth() - metrics.stringWidth(dimensions)) / 2;
                g.drawString(dimensions, dimensionsX, 30);
                String stats = String.format("This Rectangle has an area of: %.2f", area());
                int rectX = (this.getWidth() - width) / 2;
                int rectY = (this.getHeight() - height) / 2;
                g.drawRect(rectX, rectY, width, height);
                int statsX = (this.getWidth() - metrics.stringWidth(stats)) / 2;
                int statsY = rectY + height + 45;
                g.drawString(stats, statsX, statsY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.width = values.get(0);
        this.height = values.get(1);
    }
}