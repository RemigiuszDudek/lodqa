package com.dudek.calculator;

import com.dudek.calculator.calculation.FieldCalculationStrategy;
import com.dudek.calculator.figure.Figure;

public class FieldCalculator {
    CalculationStrategyChooser calculationStrategyChooser = new CalculationStrategyChooser();

    public double calculateFieldOf(Figure figure) {
        FieldCalculationStrategy fieldCalculationStrategy = calculationStrategyChooser.chooseFieldCalculationStrategy(figure);
        return fieldCalculationStrategy.calculateFieldFor(figure);
    }
}
