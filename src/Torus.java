/**
 * File Name: Torus.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Torus extends the ThreeDimensionalShape class and has methods to calculate the volume of a torus and display
 * it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape
 * (inner radius, outer radius), pass the values of these dimensions, and draw the shape.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Torus extends ThreeDimensionalShape {
    private int innerRadius, outerRadius;

    public Torus() {
    }

    @Override
    public double volume() {
        return 2 * Math.pow(Math.PI, 2) * outerRadius * Math.pow(innerRadius, 2);
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Inner Radius",
                "Outer Radius"
        };
    }

    @Override
    public JPanel drawShape() throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/img/torus.png")));
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
                int innerOuterRadiusLabelX = (getWidth() - fontMetrics.stringWidth(String.format("Inner Radius: %d, Outer Radius: %d", innerRadius, outerRadius))) / 2;
                g.drawString(String.format("Inner Radius: %d, Outer Radius: %d", innerRadius, outerRadius), innerOuterRadiusLabelX, 15);
                int volumeLabelY = imageY + imageHeight + 15;
                int volumeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("This Torus has a volume of: %.2f", volume()))) / 2;
                g.drawString(String.format("This Torus has a volume of: %.2f", volume()), volumeLabelX, volumeLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.innerRadius = values.get(0);
        this.outerRadius = values.get(1);
    }
}