package de.taulinger.bddplay.ba;

import com.microsoft.playwright.Page;
import de.taulinger.bddplay.BasicStep;
import de.taulinger.bddplay.BrowserHelper;
import de.taulinger.bddplay.drivers.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import static org.junit.Assert.assertEquals;

public class MainMenuMobileStep extends BasicStep {

    @After
    @Override
    public void after() {
        super.after();
    }


    @And("I accept cookies")
    public void iAcceptCookies() {
        page = BrowserHelper.getCurrentPage();
        HomePage homePage = new HomePage(page);
        homePage.acceptCookies();
    }
}
