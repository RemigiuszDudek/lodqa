package system.web.pages;

import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;

import java.util.ArrayList;
import java.util.List;

public class HomePageFacade {
    private HomePage homePage;

    public void go() {
        homePage.go();
    }

    public List<String> getAllPostTitles() {
        List<String> postTitles = new ArrayList<String>();
        FluentWebElements elements = homePage.getPostTitles();
        for (FluentWebElement element : elements) {
            postTitles.add(element.link().getText().toString());
        }
        return postTitles;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public void lookFor(String keyWord) {
        homePage.lookForKeyWord(keyWord);
    }
}
