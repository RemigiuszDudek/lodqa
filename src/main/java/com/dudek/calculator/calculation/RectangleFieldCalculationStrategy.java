package com.dudek.calculator.calculation;

import com.dudek.calculator.figure.Figure;
import com.dudek.calculator.figure.Rectangle;

public class RectangleFieldCalculationStrategy implements FieldCalculationStrategy{
    @Override
    public boolean apply(Figure figure) {
        return (figure instanceof Rectangle);
    }

    @Override
    public double calculateFieldFor(Figure figure) {
        int width = ((Rectangle)figure).getWidth();
        int length = ((Rectangle)figure).getLength();
        return length*width;
    }
}
