package de.taulinger.bddplay;

import com.microsoft.playwright.*;
import java.util.Map;
import static java.util.stream.Collectors.joining;

public class BasicStep {
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;


    public void after() {
        BrowserHelper.closeSession();
    }
}
