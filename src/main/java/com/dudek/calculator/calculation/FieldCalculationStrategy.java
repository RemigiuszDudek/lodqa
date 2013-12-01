package com.dudek.calculator.calculation;

import com.dudek.calculator.figure.Figure;

public interface FieldCalculationStrategy {
    boolean apply(Figure figure);
    double calculateFieldFor(Figure figure);
}
