package system.web;

import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;

import java.util.List;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

@UsingEmbedder
@RunWith(SpringAnnotatedEmbedderRunner.class)
@UsingSpring(resources = {"/system/web/web-context.xml"})
@Configure(
        storyControls = JBehaveWebAnnotatedScenario.MyStoryControls.class,
        storyPathResolver = CasePreservingResolver.class,
        storyReporterBuilder = JBehaveWebAnnotatedScenario.MyStoryReporterBuilder.class)
//@UsingSteps(instances = {BasicScenario.class})
public class JBehaveWebAnnotatedScenario extends JUnitStories {

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths("./target/test-classes", "**/web/scenario/*.story", "");
    }

    public static class MyStoryReporterBuilder extends StoryReporterBuilder {
        public MyStoryReporterBuilder() {
            super.withDefaultFormats()
                    .withFailureTrace(true)
                    .withFormats(CONSOLE, HTML)
                    .withFailureTraceCompression(true)
                    .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName());
        }
    }

    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            super.doDryRun(false).doSkipScenariosAfterFailure(false);
        }
    }
}


