/**
 * File Name: DrawShape.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: DrawShape is an extension of the JFrame class which creates a GUI for displaying shapes. The drawShape
 * method draws the shape by calling the drawShape method of the currentShape object and sets the content pane of the
 * JFrame to the returned JPanel. The JFrame is then made visible.
 */

import javax.swing.*;
import java.awt.*;

public class DrawShape extends JFrame {
    private final Shape currentShape;

    public DrawShape(Shape currentShape) {
        super(currentShape.toString());
        this.currentShape = currentShape;
        this.setSize(350, 375);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }

    public void drawShape() {
        JPanel shapePanel;
        try {
            shapePanel = currentShape.drawShape();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while drawing the shape: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        shapePanel.setBackground(Color.WHITE);
        shapePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setContentPane(shapePanel);
        this.setVisible(true);
    }
}