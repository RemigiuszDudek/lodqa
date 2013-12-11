package system.web.scenario;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import system.web.JBehaveAbstractWebScenario;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class BasicScenario extends JBehaveAbstractWebScenario {

    @Given("I am on the main blog page")
    public void goToHomePage() {
        homePageFacade.go();
    }

    @When("I look for a keyword $keyWord")
    public void whenLookingForKeyword(String keyWord) {
        homePageFacade.lookFor(keyWord);
    }

    @Then("following posts appear: $intendedVisiblePostsList")
    public void thenFollowingPostAppear(List<String> intendedVisiblePostsList) {
        List<String> visiblePosts = homePageFacade.getAllPostTitles();

        assertThat(visiblePosts.size(), is(equalTo(intendedVisiblePostsList.size())));
        assertThat(visiblePosts, hasItems(toArray(intendedVisiblePostsList)));
    }

    private String[] toArray(List<String> intendedVisiblePostsList) {
        return intendedVisiblePostsList.toArray(new String[intendedVisiblePostsList.size()]);
    }
}
