package system.web.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.seleniumhq.selenium.fluent.FluentWebElements;

public class HomePage extends FluentWebDriverPage {

    public HomePage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void go() {
        get("http://testersthoughtsuncombed.blogspot.com/");
    }

    public FluentWebElements getPostTitles() {
        return h3s(By.xpath("//h3[@class='post-title entry-title']"));
    }

    public void lookForKeyWord(String keyWord) {
        get("http://testersthoughtsuncombed.blogspot.com/search?q=" + keyWord);
    }
}
