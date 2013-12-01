package com.dudek.calculator;

import com.dudek.calculator.calculation.FieldCalculationStrategy;
import com.dudek.calculator.figure.Figure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CalculationStrategyChooserTest {

    private CalculationStrategyChooser calculationStrategyChooser;
    @Mock private FieldCalculationStrategy applicableFieldCalculationStrategy;
    @Mock private FieldCalculationStrategy notApplicableFieldCalculationStrategy;
    @Mock private Figure figure;
    private List<FieldCalculationStrategy> fieldCalculationStrategies;

    @Before
    public void setup() {
        given(applicableFieldCalculationStrategy.apply(any(Figure.class))).willReturn(true);
        given(notApplicableFieldCalculationStrategy.apply(any(Figure.class))).willReturn(false);
        fieldCalculationStrategies = new ArrayList<FieldCalculationStrategy>();
    }

    @Test
    public void shouldChooseApplicableStrategyForFigure() throws Exception {
        calculationStrategyChooser = givenChooserWithApplicableStrategyOnTheList();

        FieldCalculationStrategy chosenStrategy = calculationStrategyChooser.chooseFieldCalculationStrategy(figure);

        assertThat(chosenStrategy, is(equalTo(applicableFieldCalculationStrategy)));
    }

    @Test (expected = RuntimeException.class)
    public void shouldThrowExceptionIfThereIsNotApplicableStrategy() {
        calculationStrategyChooser = givenChooserWithoutApplicableStrategy();

        calculationStrategyChooser.chooseFieldCalculationStrategy(figure);
    }

    private CalculationStrategyChooser givenChooserWithoutApplicableStrategy() {
        fieldCalculationStrategies.add(notApplicableFieldCalculationStrategy);
        fieldCalculationStrategies.add(notApplicableFieldCalculationStrategy);

        return new CalculationStrategyChooser(fieldCalculationStrategies);
    }

    private CalculationStrategyChooser givenChooserWithApplicableStrategyOnTheList() {
        fieldCalculationStrategies.add(notApplicableFieldCalculationStrategy);
        fieldCalculationStrategies.add(applicableFieldCalculationStrategy);

        return new CalculationStrategyChooser(fieldCalculationStrategies);
    }
}
