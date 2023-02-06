/**
 * File Name: ShapeFactory.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: ShapeFactory is an extension of the JFrame class. This is the main GUI the user interacts with in order to
 * select a desired shape from a combo box and enter the appropriate dimensions for the shape. Three-dimensional shapes
 * are depicted by an image that is displayed in a new panel.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class ShapeFactory extends JFrame {
    private final ArrayList<Panel> panels = new ArrayList<>();
    private Shape selectedShape;

    public ShapeFactory() {
        super("Shape Factory");
        Shape[] shapeList = new Shape[]{
                new Circle(),
                new Square(),
                new Triangle(),
                new Rectangle(),
                new Sphere(),
                new Cube(),
                new Cone(),
                new Cylinder(),
                new Torus()
        };
        JComboBox<Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel mainMenu = new JPanel(new GridLayout(0, 1));
        JButton drawButton = new JButton("Draw Shape");
        mainMenu.add(new JLabel("Please select a shape from the following menu: "));
        mainMenu.add(shapeJComboBox);
        this.setSize(400, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainMenu);
        this.setVisible(true);
        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener((event) -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                panels.forEach(mainMenu::remove);
                panels.clear();
                mainMenu.revalidate();
                this.selectedShape = (Shape) event.getItem();
                String[] dimensions = selectedShape.getDimensions();
                panels.add(new Panel(dimensions));
                panels.forEach(mainMenu::add);
                mainMenu.add(drawButton);
                this.pack();
            }
        });

        drawButton.addActionListener((event) -> {
            DrawShape drawShape = new DrawShape(selectedShape);
            try {
                ArrayList<Integer> values = new ArrayList<>();
                panels.forEach(panel ->
                        panel.getTextFields().forEach(text ->
                                values.add(Integer.parseInt(text.getText()))));
                if (values.stream().allMatch(v -> v > 0)) {
                    selectedShape.passDimensions(values);
                    drawShape.drawShape();
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Invalid input. Please try again.",
                            "Uh-oh", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                        "Invalid input. Please ensure that all inputs are positive integers.",
                        "NumberFormatException", JOptionPane.ERROR_MESSAGE);
                panels.forEach(panel ->
                        panel.getTextFields().forEach(text -> text.setText("")));
            }
        });
    }
}