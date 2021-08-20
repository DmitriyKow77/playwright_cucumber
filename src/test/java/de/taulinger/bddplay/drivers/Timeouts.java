package de.taulinger.bddplay.drivers;

import com.microsoft.playwright.Page;

public enum Timeouts{
    XS (new Page.WaitForSelectorOptions()
            .withTimeout(1000)),
    S (new Page.WaitForSelectorOptions()
            .withTimeout(5000)),
    M (new Page.WaitForSelectorOptions()
            .withTimeout(10000)),
    L (new Page.WaitForSelectorOptions()
            .withTimeout(20000)),
    XL (new Page.WaitForSelectorOptions()
            .withTimeout(20000));

    private final Page.WaitForSelectorOptions timeout;

    Timeouts(Page.WaitForSelectorOptions timeout) {
        this.timeout = timeout;
    }

    public Page.WaitForSelectorOptions value() {
        return timeout;
    }
}
