package de.taulinger.bddplay.drivers;

import com.microsoft.playwright.Page;

public class BasePage {
    public String nameSelector(String name){
        return String.format("css=[name=\"%s\"]", name);
    }
}

