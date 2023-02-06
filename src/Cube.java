/**
 * File Name: Cube.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Cube extends the ThreeDimensionalShape class and has methods to calculate the volume of a cube and display
 * it graphically in a JPanel. It also provides methods to retrieve the dimensions of the shape (side), pass the values
 * of these dimensions, and draw the shape.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Cube extends ThreeDimensionalShape {
    private int edge;

    public Cube() {
    }

    @Override
    public double volume() {
        return Math.pow(edge, 3);
    }

    @Override
    public String[] getDimensions() {
        return new String[]{
                "Edge"
        };
    }

    @Override
    public JPanel drawShape() throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/img/cube.png")));
        Image reScaledImage = image.getScaledInstance(300, 300, image.getType());
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
                int edgeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("Edge: %d", edge))) / 2;
                g.drawString(String.format("Edge: %d", edge), edgeLabelX, 15);
                int volumeLabelY = imageY + imageHeight + 15;
                int volumeLabelX = (getWidth() - fontMetrics.stringWidth(String.format("This Cube has a volume of: %.2f", volume()))) / 2;
                g.drawString(String.format("This Cube has a volume of: %.2f", volume()), volumeLabelX, volumeLabelY);
            }
        };
    }

    @Override
    public void passDimensions(ArrayList<Integer> values) {
        this.edge = values.get(0);
    }
}