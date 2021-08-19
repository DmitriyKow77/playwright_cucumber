package de.taulinger.bddplay.drivers;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void requestDemo() {
        page.click("text=Request A Demo");
    }

    public void acceptCookies(){
        page.click("css=#hs-en-cookie-confirmation-buttons-area a");
    }
}
