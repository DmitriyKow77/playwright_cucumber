package de.taulinger.bddplay.drivers;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class DemoPage extends BasePage {
    private Page page;

    public DemoPage(Page page) {
        this.page = page;
    }

    public void setInputValue(DemoFormInputs input, String value){
        page.fill(this.nameSelector(input.getName()), value);
    }

    public void selectCountry() {
        String countrySelector = this.nameSelector(DemoFormInputs.Country.getName());
        page.click(countrySelector);
        ElementHandle dropdown = page.querySelector(countrySelector);
        dropdown.selectOption("Andorra");
    }

    public void clickSubmit(){
        page.click("css=input[value=\"Submit\"]");
    }

    public void selectIam() {
        String representativeSelector = this.nameSelector(DemoFormInputs.Iam.getName());
        page.click(representativeSelector);
        ElementHandle dropdown = page.querySelector(representativeSelector);
        dropdown.selectOption("Other");
    }

    public ElementHandle getError() {
        return page.waitForSelector("css=.hs_error_rollup", Timeouts.M.value());
    }
}
