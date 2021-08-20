package de.taulinger.bddplay.ba;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import de.taulinger.bddplay.BasicStep;
import de.taulinger.bddplay.drivers.DemoFormInputs;
import de.taulinger.bddplay.drivers.DemoPage;
import de.taulinger.bddplay.drivers.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;


public class SpaceIqFirst extends BasicStep {
    private DemoPage demoPage;

    @Given("I open SpaceIq home page with {string} for {string} usage")
    public void iOpenSpaceIqHomePageWithChromiumForDesktopUsage(String browserType, String platform) {
        final String homeUrl = "https://spaceiq.com/";
        browser = browserHelper.createInstance(browserType);
        page = browserHelper.navigate(homeUrl, platform, null);
        page.waitForLoadState(Page.LoadState.NETWORKIDLE);
        context = browserHelper.getContext();
    }

    @When("I click button \"Request a demo\"")
    public void iClickButton() {
        Page newPage = context.waitForPage(() -> {
            HomePage homePage = new HomePage(page);
            homePage.requestDemo();
        });
        newPage.waitForLoadState();
        System.out.println(newPage.title());
        demoPage = new DemoPage(newPage);
    }

    @Then("I fill demo form partially")
    public void demoFormPageOpens(){
        demoPage.setInputValue(DemoFormInputs.FirstName, "Automation User");
        demoPage.setInputValue(DemoFormInputs.LastName, "Automative");
        demoPage.setInputValue(DemoFormInputs.JobTitle, "Automation developer");
        demoPage.setInputValue(DemoFormInputs.Phone, "93799922");
        demoPage.setInputValue(DemoFormInputs.Email, "test@ma.qa");
        demoPage.setInputValue(DemoFormInputs.CompanyName, "SpaceIQ QA");

        demoPage.selectCountry();
        demoPage.selectIam();
    }

    @When("I submit a form")
    public void iSubmitAForm() {
        demoPage.clickSubmit();
    }

    @Then("I verify an error appears {string}")
    public void iVerifyAnErrorAppears(String expectedError) {
        ElementHandle error = demoPage.getError();
        error.waitForElementState(ElementHandle.ElementState.VISIBLE);
        assertEquals(error.textContent(), expectedError);
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        page = browserHelper.getCurrentPage();
        HomePage homePage = new HomePage(page);
        homePage.acceptCookies();
    }
}
