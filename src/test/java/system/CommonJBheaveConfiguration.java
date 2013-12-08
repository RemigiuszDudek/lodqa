package system;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class CommonJBheaveConfiguration {
    public static Configuration create() {
        return new MostUsefulConfiguration()
                .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryPathResolver(new CasePreservingResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withFormats(Format.CONSOLE, Format.HTML)
                                .withFailureTrace(true)
                                .withFailureTraceCompression(true));
    }
}
