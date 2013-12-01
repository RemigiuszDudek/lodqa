package system.web.scenario;

import com.google.common.collect.ImmutableList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import system.web.JBehaveAbstractWebScenario;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.fail;

public class BasicScenario extends JBehaveAbstractWebScenario {
    private static final List<String> ALL_POST_TITLES = ImmutableList.<String>builder()
            .add("Behaviour Driven Development")
            .add("Money and self organized teams")
            .add("Statement coverage .vs. Branch coverage .vs. Path coverage")
            .add("Agile vs Scrum")
            .add("Agile vs Waterfall")
            .build();

    @Given("I am on the main blog page")
    public void goToHomePage() {
        homePageFacade.go();
    }

    @When("I look for a keyword $keyWord")
    public void whenLookingForKeyword(String keyWord) {
        homePageFacade.lookFor(keyWord);
    }

    @Then("all posts should be present on the page")
    public void allPostsAreAvailable() {
        List<String> postTitles = homePageFacade.getAllPostTitles();
        assertThatListsContainTheSameElements(postTitles, ALL_POST_TITLES);
    }

    @Then("following posts appear: $intendedVisiblePostsList")
    public void thenFollowingPostAppear(List<String> $intendedVisiblePostsList) {
        List<String> visiblePosts = homePageFacade.getAllPostTitles();

        assertThatListsContainTheSameElements(visiblePosts, $intendedVisiblePostsList);
    }

    private void assertThatListsContainTheSameElements(List<String> toBeCheckedList, List<String> checkAgainst) {
        if (toBeCheckedList.size() != checkAgainst.size()) {
            fail("There are different number of items in both lists:" +
                    "\ntoBeCheckedList: " + listToString(toBeCheckedList) +
                    "\ncheckAgainstList: " + listToString(checkAgainst));
        }
        for (String itemToBeCheckedAgainst : checkAgainst) {
            Assert.assertThat(toBeCheckedList, hasItem(itemToBeCheckedAgainst));
        }
    }

    private static String listToString(List<String> toBeCheckedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : toBeCheckedList) {
            stringBuilder.append(item).append(", ");
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(","), stringBuilder.length());
        return stringBuilder.toString();
    }
}
