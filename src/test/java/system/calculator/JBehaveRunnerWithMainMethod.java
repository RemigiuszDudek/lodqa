package system.calculator;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.util.Arrays;
import java.util.Properties;

public class JBehaveRunnerWithMainMethod {
    private static Embedder embedder = new Embedder();

    public static void main(String[] args) {
//        embedder.candidateSteps().add(new FieldCalculatorWithRegularVariableScenario());
        embedder.useConfiguration(configuration());
        embedder.runStoriesAsPaths(
                Arrays.asList("system/calculator/FieldCalculator.story"));
    }

    private static Configuration configuration() {
        CrossReference xref = new CrossReference();
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.HTML)
                                .withFailureTrace(true)
                                .withFailureTraceCompression(true)
                                .withCrossReference(xref))
                .useStepMonitor(xref.getStepMonitor());
    }
}