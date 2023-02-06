/**
 * File Name: Shape.java
 * Date: 05 FEB 2023
 * Author: Joseph Julian
 * Purpose: This is an abstract class named "Shape". It has methods for getting the dimensions of a shape, returning a
 * string representation of the shape's name, creating a visual representation of the shape using a JPanel, and passing
 * the dimensions of the shape to the code.
 */

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Shape {
    public abstract String[] getDimensions();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract JPanel drawShape() throws IOException;

    public abstract void passDimensions(ArrayList<Integer> values);
}