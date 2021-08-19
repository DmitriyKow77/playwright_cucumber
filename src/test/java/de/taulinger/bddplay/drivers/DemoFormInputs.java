package de.taulinger.bddplay.drivers;

public enum DemoFormInputs {
    FirstName ("firstname"),
    LastName ("lastname"),
    JobTitle ("jobtitle"),
    Phone ("phone"),
    CompanyName ("company"),
    Email ("email"),
    Country("country_selects"),
    Iam("i_am");

    private final String name;

    DemoFormInputs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
