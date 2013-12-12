package system.web;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import system.CommonJBheaveConfiguration;

public class JBehaveWebScenario extends JUnitStory {

    public InjectableStepsFactory stepsFactory() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/system/web/web-context.xml");

        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        listableBeanFactory.registerBeanDefinition(getClass().getSimpleName(), new RootBeanDefinition(getClass()));

        return new SpringStepsFactory(configuration(), context);
    }

    @Override
    public Configuration configuration() {
        return CommonJBheaveConfiguration.create();
    }
}
