package de.taulinger.bddplay.drivers;

public class BasePage {
    public String nameSelector(String name){
        return String.format("css=[name=\"%s\"]", name);
    }
}
