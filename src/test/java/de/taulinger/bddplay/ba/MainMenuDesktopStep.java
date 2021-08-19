package de.taulinger.bddplay.ba;

import de.taulinger.bddplay.BasicStep;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import static org.junit.Assert.assertEquals;

public class MainMenuDesktopStep extends BasicStep {

    @After
    @Override
    public void after() {
        super.after();
    }


    @Then("The main menu should show a button for desktop usage")
    public void the_main_menu_should_show_a_button() {
//        page.screenshot(new Page.ScreenshotOptions().withPath(Paths.get("screenshot.png")));
        assertEquals("Menü öffnen", page.innerText(".ga-visible-collapsed"));
    }
}
