/**
 * File Name: Panel.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: Panel class is an extension of the JPanel class. The purpose of this class is to display a list of text
 * fields, where each text field corresponds to a shape dimension specified in the input parameter shapeDimensions.
 */

import javax.swing.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    private final ArrayList<JTextField> textFields;

    public Panel(String[] shapeDimensions) {
        textFields = new ArrayList<>();
        for (String dimension : shapeDimensions) {
            JLabel label = new JLabel(dimension);
            JTextField textField = new JTextField(2);
            textFields.add(textField);
            add(label);
            add(textField);
        }
    }

    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }
}