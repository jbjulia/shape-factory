/**
 * File Name: Cylinder.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Cylinder extends the ThreeDimensionalShape class and has methods to calculate the volume of a cylinder and
 * display it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape
 * (radius, height), pass the values of these dimensions, and draw the shape.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Cylinder extends ThreeDimensionalShape {
    private int radius, height;

    public Cylinder() {
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Radius",
                "Height"
        };
    }

    @Override
    public JPanel drawShape() throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/img/cylinder.png")));
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
                int radiusHeightLabelX = (getWidth() - fontMetrics.stringWidth(String.format("Radius: %d, Height: %d", radius, height))) / 2;
                g.drawString(String.format("Radius: %d, Height: %d", radius, height), radiusHeightLabelX, 15);
                int volumeLabelY = imageY + imageHeight + 15;
                int volumeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("This Cylinder has a volume of: %.2f", volume()))) / 2;
                g.drawString(String.format("This Cylinder has a volume of: %.2f", volume()), volumeLabelX, volumeLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.radius = values.get(0);
        this.height = values.get(1);
    }
}