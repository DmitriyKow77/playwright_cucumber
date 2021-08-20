package de.taulinger.bddplay;

import com.microsoft.playwright.*;
import java.util.Map;
import static java.util.stream.Collectors.joining;

public class BrowserHelper {
    private  Browser browser = null;
    private  BrowserContext context = null;
    private  Page page = null;

    public  Browser createInstance(String browserTypeAsString) {
        if (browser == null) {
            BrowserType browserType = null;
            switch (browserTypeAsString) {
                case "Firefox":
                    browserType = Playwright
                            .create()
                            .firefox();
                    break;
                case "Chromium":
                    browserType = Playwright
                            .create()
                            .chromium();
                    break;
                case "Webkit":
                    browserType = Playwright
                            .create()
                            .webkit();
                    break;

            }
            if (browserType == null) {
                throw new IllegalArgumentException("Could not launch a browser for type " + browserTypeAsString);
            }
            final BrowserType.LaunchOptions browserOptions = new BrowserType.LaunchOptions()
                    .withHeadless(false)
                    .withSlowMo(30);

            browser = browserType.launch(browserOptions);
            context = browser.newContext();
        }
        return browser;
    }

    public  Browser getBrowser() {
        if (browser == null) {
            throw new Error("you need init browser first!");
        }
        return browser;
    }

    public  BrowserContext getContext(){
        if (context == null) {
            throw new Error("you need init browser first!");
        }
        return context;
    }

    public  Page getCurrentPage(){
        if (page == null) {
            throw new Error("you need navigate to page first!");
        }
        return page;
    }

    public  Page navigate(String baseUrl, String clientType, Map<String, String> queryParams) {
        if (clientType.equals("mobile")) {
            page = newPage(context = newMobileBrowserContext());
            if (queryParams == null || queryParams.isEmpty()) {
                queryParams = Map.of("mobile", "true");
            } else {
                queryParams.put("mobile", "true");
            }
        } else {
            page = newPage(context = newDesktopBrowserContext());
        }

        if (queryParams == null || queryParams.isEmpty()) {
            page.navigate(baseUrl);
        } else {
            final String queryParamsAsString = queryParams.entrySet().stream().
                    map(entry -> "&" + entry.getKey() + "=" + entry.getValue())
                    .collect(joining("&"));
            page.navigate(baseUrl + "?" + queryParamsAsString);
        }
        return page;
    }

    public  void closeSession(){
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (context != null) {
            context.close();
            context = null;
        }
        if (page != null) {
            page.close();
            page = null;
        }
    }

    protected  Page newPage(BrowserContext browserContext) {
        return browserContext.newPage();
    }

    protected  BrowserContext newDesktopBrowserContext() {
        return browser.newContext(new Browser.NewContextOptions().withViewport(1800, 1200));
    }

    protected  BrowserContext newMobileBrowserContext() {
        return browser.newContext(new Browser.NewContextOptions().withViewport(375, 667).withDeviceScaleFactor(2));
    }
}
