package system.web;

import system.web.pages.HomePageFacade;

public class JBehaveAbstractWebScenario extends JBehaveWebScenario {
    protected static HomePageFacade homePageFacade;

    public void setHomePageFacade(HomePageFacade aHomePageFacade) {
        homePageFacade = aHomePageFacade;
    }

}
