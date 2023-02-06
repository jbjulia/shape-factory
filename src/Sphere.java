/**
 * File Name: Sphere.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Sphere extends the ThreeDimensionalShape class and has methods to calculate the volume of a sphere and
 * display it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (radius), pass
 * the values of these dimensions, and draw the shape.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Sphere extends ThreeDimensionalShape {
    private int radius;

    public Sphere() {
    }

    @Override
    public double volume() {
        return 4.0d / 3.0d * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Radius"
        };
    }

    @Override
    public JPanel drawShape() throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/img/sphere.png")));
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
                int radiusLabelX = (getWidth() - fontMetrics.stringWidth(String.format("Radius: %d", radius))) / 2;
                g.drawString(String.format("Radius: %d", radius), radiusLabelX, 15);
                int volumeLabelY = imageY + imageHeight + 15;
                int volumeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("This Sphere has a volume of: %.2f", volume()))) / 2;
                g.drawString(String.format("This Sphere has a volume of: %.2f", volume()), volumeLabelX, volumeLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.radius = values.get(0);
    }
}