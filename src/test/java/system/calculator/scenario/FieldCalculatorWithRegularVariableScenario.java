package system.calculator.scenario;

import com.dudek.calculator.FieldCalculator;
import com.dudek.calculator.figure.Circle;
import com.dudek.calculator.figure.Figure;
import com.dudek.calculator.figure.Rectangle;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class FieldCalculatorWithRegularVariableScenario {
    Figure figure;
    FieldCalculator testee = new FieldCalculator();
    double result;

    @Given("a circle with radius $whatever")
    public void givenCircleWithRadius(@Named("radius") int radius) {
        figure = new Circle(radius);
    }

    @Given("rectangle with sides $table")
    public void givenRectangleWithSides(ExamplesTable table) {
        Map<String, String> row = table.getRows().get(0);
        figure = new Rectangle(valueOf(row.get("a")), valueOf(row.get("b")));
    }

    @When("asked to compute field")
    @Alias("asked to compute field for a rectangle")
    public void whenAskedToComputeFigureField() {
        result = testee.calculateFieldOf(figure);
    }

    @Then(value = "should return PI", priority = 1)
    public void thenShouldReturnFieldOfValuePI() {
        assertEquals(Math.PI, result, 0.001);
    }

    @Then("should return $whatever")
    public void thenShouldReturnResultAsFieldValue(@Named("result") double result) {
        assertEquals(result, this.result, 0.001);
    }
}
