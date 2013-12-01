package system.web;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class JBehaveWebScenario extends JUnitStory {

    public InjectableStepsFactory stepsFactory() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/system/web/web-context.xml");

        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        listableBeanFactory. registerBeanDefinition(getClass().getSimpleName(), new RootBeanDefinition(getClass()));

        return new SpringStepsFactory(configuration(), context);
    }

    public Configuration configuration() {
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryPathResolver(new CasePreservingResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFailureTrace(true)
                                .withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML)
                                .withFailureTraceCompression(true)
//                                .withCrossReference(xref)
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName()));
//                .useStepMonitor(xref.getStepMonitor());

    }


}
