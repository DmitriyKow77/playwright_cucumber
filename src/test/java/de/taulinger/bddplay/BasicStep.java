package de.taulinger.bddplay;
import com.microsoft.playwright.*;


public class BasicStep {
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected BrowserHelper browserHelper = new BrowserHelper();

    public void after() {
        browserHelper.closeSession();
    }
}
