/**
 * File Name: Cone.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Cone extends the ThreeDimensionalShape class and has methods to calculate the volume of a cone and display
 * it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (base radius, height),
 * pass the values of these dimensions, and draw the shape.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Cone extends ThreeDimensionalShape {
    private int baseRadius, height;

    public Cone() {
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(baseRadius, 2) * height / 3;
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Base Radius",
                "Height"
        };
    }

    @Override
    public JPanel drawShape() throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/img/cone.png")));
        Image reScaledImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                FontMetrics fontMetrics = g.getFontMetrics();
                int imageWidth = reScaledImage.getWidth(null);
                int imageHeight = reScaledImage.getHeight(null);
                int imageX = (getWidth() - imageWidth) / 2;
                int imageY = (getHeight() - imageHeight) / 2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int baseRadiusHeightLabelX = (getWidth() - fontMetrics.stringWidth(String.format("Base Radius: %d, Height: %d", baseRadius, height))) / 2;
                g.drawString(String.format("Base Radius: %d, Height: %d", baseRadius, height), baseRadiusHeightLabelX, 15);
                int volumeLabelY = imageY + imageHeight + 15;
                int volumeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("This Cone has a volume of: %.2f", volume()))) / 2;
                g.drawString(String.format("This Cone has a volume of: %.2f", volume()), volumeLabelX, volumeLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.baseRadius = values.get(0);
        this.height = values.get(1);
    }
}