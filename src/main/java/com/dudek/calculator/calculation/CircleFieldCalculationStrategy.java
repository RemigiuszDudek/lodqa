package com.dudek.calculator.calculation;

import com.dudek.calculator.figure.Circle;
import com.dudek.calculator.figure.Figure;

public class CircleFieldCalculationStrategy implements FieldCalculationStrategy {
    @Override
    public boolean apply(Figure figure) {
        return (figure instanceof Circle);
    }

    @Override
    public double calculateFieldFor(Figure figure) {
        Circle circle = (Circle) figure;
        int radius = circle.getRadius();
        return radius >= 0 ? Math.PI * (Math.pow(radius, 2)) : -1;
    }
}
