/**
 * File Name: Square.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Square extends the TwoDimensionalShape class and has methods to calculate the area of a square and display
 * it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (side), pass the values
 * of these dimensions, and draw the shape.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Square extends TwoDimensionalShape {
    private int side;

    public Square() {
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Sides"
        };
    }

    @Override
    public JPanel drawShape() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String stats = String.format("This Square has an area of: %.2f", area());
                FontMetrics metrics = g.getFontMetrics();
                int rectX = (this.getWidth() - side) / 2;
                int rectY = (this.getHeight() - side) / 2;
                int stringX = (this.getWidth() - metrics.stringWidth(stats)) / 2;
                int stringY = rectY + side + 30;
                g.drawString(String.format("Side: %d", side), (this.getWidth() - metrics.stringWidth(String.format("Side: %d", side))) / 2, 15);
                g.drawRect(rectX, rectY, side, side);
                g.drawString(stats, stringX, stringY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.side = values.get(0);
    }
}