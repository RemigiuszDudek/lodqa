package system.calculator;

import org.jbehave.core.junit.JUnitStories;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

public class JBehaveRunnerExtendingJUnitStories extends JUnitStories {

    @Before
    public void initialise() {
//        this.configuredEmbedder().candidateSteps()
//                .add(new FieldCalculatorWithRegularVariableScenario());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("system/calculator/FieldCalculator.story");
    }
}
