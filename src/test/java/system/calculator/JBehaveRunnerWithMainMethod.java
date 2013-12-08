package system.calculator;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import system.CommonJBheaveConfiguration;
import system.calculator.scenario.FieldCalculatorWithRegularVariableScenario;

import java.util.Arrays;

public class JBehaveRunnerWithMainMethod {
    private static Embedder embedder = new Embedder();

    public static void main(String[] args) {
        embedder.candidateSteps().add(new FieldCalculatorWithRegularVariableScenario());
        embedder.useConfiguration(configuration());
        embedder.runStoriesAsPaths(
                Arrays.asList("system/calculator/FieldCalculator.story"));
    }

    private static Configuration configuration() {
        return CommonJBheaveConfiguration.create();
    }
}