package com.dudek.calculator;

import com.dudek.calculator.calculation.CircleFieldCalculationStrategy;
import com.dudek.calculator.calculation.FieldCalculationStrategy;
import com.dudek.calculator.calculation.RectangleFieldCalculationStrategy;
import com.dudek.calculator.figure.Figure;

import java.util.Arrays;
import java.util.List;

public class CalculationStrategyChooser {
    List<FieldCalculationStrategy> fieldCalculationStrategies;

    public CalculationStrategyChooser() {
        this(Arrays.asList(new CircleFieldCalculationStrategy(),
                new RectangleFieldCalculationStrategy()));
    }

    public CalculationStrategyChooser(List<FieldCalculationStrategy> fieldCalculationStrategies) {
        this.fieldCalculationStrategies = fieldCalculationStrategies;
    }

    public FieldCalculationStrategy chooseFieldCalculationStrategy(Figure figure) {
        for (FieldCalculationStrategy fieldCalculationStrategy : fieldCalculationStrategies) {
            if (fieldCalculationStrategy.apply(figure)) {
                return fieldCalculationStrategy;
            }
        }
        throw new RuntimeException("No strategy available for given figure");
    }
}
