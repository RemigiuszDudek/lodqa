package system.calculator;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import system.calculator.scenario.FieldCalculatorWithRegularVariableScenario;

import java.util.List;
import java.util.Properties;

import static java.util.Arrays.asList;

public class JBehaveRunnerWithStepFactoryAndNiceReporting extends JUnitStories {

    private final CrossReference xref = new CrossReference();

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new FieldCalculatorWithRegularVariableScenario());
    }

    @Override
    protected List<String> storyPaths() {
//        return asList("system/simple/FieldCalculator.story");
        return new StoryFinder().findPaths("./target/test-classes", asList("**/calculator/*.story"), null);
    }

    @Override
    public Configuration configuration() {
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats().withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML)
                                .withFailureTrace(true)
                                .withFailureTraceCompression(true)
                                .withCrossReference(xref))
                .useStepMonitor(xref.getStepMonitor())
                .usePendingStepStrategy(new FailingUponPendingStep());
    }
}
