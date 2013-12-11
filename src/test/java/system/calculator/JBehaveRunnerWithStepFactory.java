package system.calculator;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import system.CommonJBheaveConfiguration;
import system.calculator.scenario.FieldCalculatorWithRegularVariableScenario;

import java.util.Arrays;
import java.util.List;

public class JBehaveRunnerWithStepFactory extends JUnitStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new FieldCalculatorWithRegularVariableScenario());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("system/calculator/FieldCalculator.story");
    }

    @Override
    public Configuration configuration() {
        return CommonJBheaveConfiguration.create();
    }
}
